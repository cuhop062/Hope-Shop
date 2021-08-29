package edu.poly.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import edu.poly.shop.entity.Account;
import edu.poly.shop.entity.Product;

public interface AccountService {
	Account findById(String username);

	List<Account> getAdministrators();

	List<Account> findAll();
	Optional<Account> findByEmail(String email);

	void save(Account account);

	Long getSize();



	

	
}
