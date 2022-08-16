package com.stock.controllers;

import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stock.models.Company;
import com.stock.models.Customer;
import com.stock.models.HelpDesk;
import com.stock.models.UnitPrice;
import com.stock.models.User;
import com.stock.service.CompanyService;
import com.stock.service.CustomerService;
import com.stock.service.HelpDeskService;
import com.stock.service.UserService;


@Controller
public class CompanyController {
	
	@Autowired CompanyService cservice;
	@Autowired CustomerService custservice;
	@Autowired HelpDeskService hservice;
	@Autowired UserService uservice;
	@Autowired HttpSession session;

	@PostMapping("/cmpregister")
	public String saveProduct(MultipartFile photo,Company c,String pwd,RedirectAttributes ra) {
		System.out.println(photo.getOriginalFilename());
		c.setCurrentprice(c.getStockprice());
		c=cservice.saveCompany(c, photo);
		User user=new User();
		user.setUname(c.getName());
		user.setPwd(pwd);
		user.setUid(c.getId());
		user.setRole("Company");
		user.setUserid(c.getEmail());
		uservice.AddUser(user);
		
		ra.addFlashAttribute("msg", "Company registered successfully");
		return "redirect:/login";
	}
	
	@GetMapping("/updateprice")
	public String updatePricePage(Model model) {
		int custid=(int)session.getAttribute("id");
		model.addAttribute("prices",cservice.getPriceDetails(custid));
		return "updateprice";
	}
	
	@GetMapping({"helpdesk","/helpdesk/{id}"})
	public String helpdesk(@PathVariable("id") Optional<Integer> id, Model model) {
		Company cmp=cservice.findCompany((int)session.getAttribute("id"));
		model.addAttribute("list", hservice.listCompanyTickets(cmp));
		if(id.isPresent()) {
			model.addAttribute("process", true);
			model.addAttribute("hd", hservice.findTicket(id.get()));
		}
		return "helpdesk";
	}
	
	@PostMapping("/processhelp")
	public String savehelpdesk(int id,String solution) {
		hservice.updateTicket(id, solution);
		return "redirect:/helpdesk";
	}
	
	@PostMapping("/updateprice")
	public String updateprice(UnitPrice sp,String udate) {
		sp.setDate(LocalDate.parse(udate));
		cservice.addStockPrice(sp);
		return "redirect:/updateprice";
	}
	
	@GetMapping("/stockholders")
	public String stockholders(Model model) {
		int compid=(int)session.getAttribute("id");
		model.addAttribute("list", custservice.myStockHolders(compid));
		return "stockholders";
	}
}
