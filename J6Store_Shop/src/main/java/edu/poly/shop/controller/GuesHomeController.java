package edu.poly.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.shop.service.CategoryService;
import edu.poly.shop.service.ProductService;

@Controller
public class GuesHomeController {
	@Autowired
	CategoryService cateService;
	@Autowired
	ProductService productService;
	
	@RequestMapping("/layout/home")
	 public String index(Model model) {
        model.addAttribute("top9", cateService.findTop());
        return "layout/home";
    }
}
