package edu.poly.shop.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailModel {
	String form="hopapd03955@fpt.edu.vn";
	String to;
	String subject;
	String body;
	List<String> cc  = new ArrayList<>();
	List<String> bcc = new ArrayList<>();
	public MailModel(String form, String to, String subject, String body) {
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

}
