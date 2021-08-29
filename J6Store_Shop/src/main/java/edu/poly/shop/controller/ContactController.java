package edu.poly.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
	@Autowired
	JavaMailSender javaMailSender;
	
	
	@RequestMapping("/layout/contact")
	public String contact() {
		return "layout/contact";
	}
	
	@RequestMapping("/layout/contact/send")
	public String sendMail(Model model,
			@RequestParam("to") String to,
			@RequestParam("subject") String subject,
			@RequestParam("body") String body
			) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject("subject");
		msg.setText(body);
		javaMailSender.send(msg);
		model.addAttribute("message", "Đã gửi thành công");
		return "layout/contact";
	}
}
