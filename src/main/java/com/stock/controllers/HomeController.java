package com.stock.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stock.models.User;
import com.stock.service.CompanyService;
import com.stock.service.UserService;

@Controller
public class HomeController {
	
	@Autowired HttpSession session;
	@Autowired CompanyService cservice;
	@Autowired UserService uservice;
	
	@GetMapping("/")
	public String homepage() {
		return "home";
	}
	
	@GetMapping("/stocks")
	public String stockpage(Model model) {
		model.addAttribute("prods", cservice.getAll());
		return "stocks";
	}
	
	@GetMapping("/login")
	public String loginpage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String validate(String userid,String pwd,RedirectAttributes ra) {
		User user=uservice.validate(userid, pwd);
		if(user==null) {
			ra.addFlashAttribute("error", "Invalid username or password");
		}else {
			session.setAttribute("userid", user.getUserid());
			session.setAttribute("role", user.getRole());
			session.setAttribute("uname", user.getUname());
			session.setAttribute("id", user.getUid());
		}
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String customerregister() {
		return "register";
	}
	
	@GetMapping("/cmpregister")
	public String companypage() {
		return "cmpregister";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
}
