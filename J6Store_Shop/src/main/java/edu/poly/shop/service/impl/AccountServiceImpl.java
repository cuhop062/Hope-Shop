package edu.poly.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import edu.poly.shop.dao.AccountDao;
import edu.poly.shop.entity.Account;
import edu.poly.shop.entity.Product;
import edu.poly.shop.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDao adao;

	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return adao.findById(username).get();
	}

	@Override
	public List<Account> getAdministrators() {
		// TODO Auto-generated method stub
		return adao.getAdministrators();
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return adao.findAll();
	}

	

	@Override
	public Optional<Account> findByEmail(String email) {
		// TODO Auto-generated method stub
		return adao.findByEmail(email);
	}

	@Override
	public void save(Account account) {
		// TODO Auto-generated method stub
		adao.save(account);
	}

	@Override
	public Long getSize() {
		// TODO Auto-generated method stub
		return adao.getSize();
	}







}
