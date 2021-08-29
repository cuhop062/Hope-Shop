package edu.poly.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {
	
	@RequestMapping("/security/register")
	public String registerForm(Model model) {
		model.addAttribute("message", "Mời bạn đăng ký");
		return "security/register";
	}
}
