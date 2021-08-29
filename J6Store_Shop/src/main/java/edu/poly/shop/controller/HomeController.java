package edu.poly.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping({ "/", "/home/index" })
	public String home() {
		return "redirect:/layout/home";
	}

	@RequestMapping({"/admin","/admin/home/index"})
	public String admin() {
		return "redirect:/admin/index.html";
	}
}
