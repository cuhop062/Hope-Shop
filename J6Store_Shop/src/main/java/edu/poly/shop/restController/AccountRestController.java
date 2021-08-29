package edu.poly.shop.restController;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.poly.shop.entity.Account;
import edu.poly.shop.service.AccountService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountService accountService;
	@Autowired
    HttpSession session;
	
	@GetMapping
	public List<Account> getAccounts(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return accountService.getAdministrators();
		}
		return accountService.findAll();
	}
	@GetMapping(value = "countUser")
    public Long getCount() {
        return accountService.getSize();
    }
//	 @GetMapping(value = "userNow")
//	    public Account getId() {
//	        String name = (String) session.getAttribute("username");
//	        return accountService.findById(name);
//	    }

	
}
