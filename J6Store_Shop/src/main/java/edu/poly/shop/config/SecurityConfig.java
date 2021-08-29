package edu.poly.shop.config;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.poly.shop.entity.Account;
import edu.poly.shop.service.AccountService;
import edu.poly.shop.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AccountService accountService;
	@Autowired 
	UserService userService;
	
//	@Autowired
//	BCryptPasswordEncoder pe;
	//cung cap nguon du lieu dang nhap
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.userDetailsService(username -> {
//			
//		});
		auth.userDetailsService(userService);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests()
		.antMatchers("/cart/**").authenticated()
		.antMatchers("/admin/**").hasAnyRole("STAF","DIRE")
		.antMatchers("/rest/authorities").hasAnyRole("DIRE")
		.anyRequest().permitAll();
		
		http.formLogin()
		.loginPage("/security/login/form")
		.loginProcessingUrl("/security/login")
		.defaultSuccessUrl("/security/login/success",false) //dang nhap thanh cong kh nhat thiet ve success
		.failureUrl("/security/login/error");
		
		
		http.rememberMe()
		.tokenValiditySeconds(86400);
		
		http.exceptionHandling()
		.accessDeniedPage("/security/unauthoried"); //truy xuat den dia chi chưa cap quyen
		
		http.logout()
		.logoutUrl("/security/logoff")
		.logoutSuccessUrl("/security/logoff/success");
		
		//mang xa hoi
		http.oauth2Login()
		.loginPage("/security/login/form")
		.defaultSuccessUrl("/oauth2/login/success",true)
		.failureUrl("/security/login/error")
		.authorizationEndpoint()
		.baseUri("/oauth2/authorization");
	}
	
	//cơ chế mã hóa mật khẩu
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	//cho phép truy xuất REST API từ bên ngoài
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
	}
	
}
