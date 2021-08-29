package edu.poly.shop.service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import edu.poly.shop.dao.AccountDao;
import edu.poly.shop.entity.Account;
import edu.poly.shop.entity.Authority;
import edu.poly.shop.entity.Role;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	AccountService accountService;
	@Autowired
	AuthorityService authorityService;
	@Autowired
	BCryptPasswordEncoder pe;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Account user = accountService.findById(username);
			String password = pe.encode(user.getPassword());
			String[] roles = user.getAuthorities().stream().map(er -> er.getRole().getId()).collect(Collectors.toList())
					.toArray(new String[0]);
			return User.withUsername(username).password(password).roles(roles).build();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new UsernameNotFoundException(username + "not found!");
		}
	}

	public void loginFormOAuth2(OAuth2AuthenticationToken auth2) {

		String email = auth2.getPrincipal().getAttribute("email");
		String password = Long.toHexString(System.currentTimeMillis());
		Optional<Account> opt = accountService.findByEmail(email);
		if (opt.isPresent()) {
			UserDetails user = User.withUsername(email).password(pe.encode(password)).roles("CUST").build();

			Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);

		} else {
			Authority au = new Authority();
			Role rl =  new Role();
			
		    Account account = new Account();
			
		
			account.setUsername(email);
			account.setPassword(password);
			account.setEmail(email);
			account.setPhoto("");
			au.setAccount(account);
			rl.setId("CUST");
			au.setRole(rl);
			
			accountService.save(account);
			authorityService.save(au);
			UserDetails user = User.withUsername(email).password(pe.encode(password)).roles("CUST").build();

			Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		    SecurityContextHolder.getContext().setAuthentication(auth);
		
		}

	}
}
