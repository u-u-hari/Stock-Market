package com.stock.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stock.models.Customer;
import com.stock.models.CustomerList;
import com.stock.models.HelpDesk;
import com.stock.models.UnitPrice;
import com.stock.models.User;
import com.stock.service.CompanyService;
import com.stock.service.CustomerService;
import com.stock.service.HelpDeskService;
import com.stock.service.UserService;

@Controller
public class CustomerController {

	@Autowired CustomerService cservice;
	@Autowired CompanyService cmpservice;
	@Autowired UserService uservice;
	@Autowired HelpDeskService hservice;
	@Autowired HttpSession session;
	
	@PostMapping("/register")
	public String saveCustomer(Customer c,String pwd,RedirectAttributes ra) {
		c=cservice.saveCustomer(c);
		User user=new User();
		user.setUname(c.getName());
		user.setPwd(pwd);
		user.setUid(c.getId());
		user.setRole("Customer");
		user.setUserid(c.getEmail());
		uservice.AddUser(user);
		ra.addFlashAttribute("msg", "Registered Successfully");
		return "redirect:/login";
	}
	
	@GetMapping("/details/{id}")
	public String stockDetails(@PathVariable("id") int id,Model model)
	{		
		List<UnitPrice> plist= cmpservice.getPriceDetails(id);
		
		List<Integer> prices=new ArrayList<Integer>();
		List<String> dates=new ArrayList<String>();
		for(UnitPrice sp :plist) {
			prices.add(sp.getPrice());
			dates.add(sp.getDate().getDayOfMonth()+","+sp.getDate().getMonthValue());
		}
		model.addAttribute("values", prices);
		model.addAttribute("dates", dates);
		model.addAttribute("stk", cmpservice.findCompany(id));
		model.addAttribute("prices", cmpservice.getPriceDetails(id));
		return "stockdetails";
	}
	
	@PostMapping("/buynow")
	public String buynow(CustomerList cs,int custid,int compid) {
		System.out.println(cs);
		cs.setCompany(cmpservice.findCompany(compid));
		cs.setCustomer(cservice.findCustomer(custid));
		cservice.buyNow(cs);
		return "redirect:/mystocks";
	}
	
	@PostMapping("/sellnow")
	public String sellnow(int id,int qty) {
		cservice.sellNow(id,qty);
		return "redirect:/mystocks";
	}
	
	@GetMapping("/help")
	public String helpdesk(Model model) {
		model.addAttribute("clist", cmpservice.getAll());
		Customer cust=cservice.findCustomer((int)session.getAttribute("id"));
		model.addAttribute("list", hservice.listCustomerTickets(cust));
		return "help";
	}
	
	@PostMapping("/help")
	public String savehelpdesk(int compid,String description) {
		HelpDesk hd=new HelpDesk();
		hd.setCompany(cmpservice.findCompany(compid));
		Customer cust=cservice.findCustomer((int)session.getAttribute("id"));
		hd.setCustomer(cust);
		hd.setStatus("Pending");
		hd.setDescription(description);
		hservice.saveTicket(hd);
		return "redirect:/help";
	}
	
	@GetMapping({"/mystocks/{id}","/mystocks"})
	public String mystocklist(@PathVariable("id") Optional<Integer> id, Model model) {
		int custid=(int)session.getAttribute("id");
		model.addAttribute("list", cservice.myStocks(custid));
		if(id.isPresent()) {
			model.addAttribute("sell", true);
			model.addAttribute("stk", cservice.findStockById(id.get()));
		}
		return "mystocks";
	}
}
