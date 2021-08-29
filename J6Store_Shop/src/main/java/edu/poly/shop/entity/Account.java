package edu.poly.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
	@Id
	String username;
	String password;
	String fullname;
	String email;
	String photo;
	// tạo mã thông báo đặt lại mật khẩu ngẫu nhiên
	String resetToken;
	// mã xác nhận đăng nhập
	String verificationCode;
	Boolean enabled;
	// thời gian hết hạn mật khẩu
	Date passwordChangedTime;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;
}
