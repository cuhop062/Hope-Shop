package edu.poly.shop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.poly.shop.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/order/checkout")
	public String checkout() { //kiem tra hang hoa
		return "order/checkout";
	}
	@RequestMapping("/order/list")
	public String list(Model model, HttpServletRequest request) { //danh sach hang dar
		String username = request.getRemoteUser(); //lay user nguoi dang nhap
		model.addAttribute("orders", orderService.findByUsername(username));
		return "order/list";
	}
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {//kiem tra chi tiet hang dat
		model.addAttribute("order", orderService.findById(id));
		return "order/detail";
	}
}
