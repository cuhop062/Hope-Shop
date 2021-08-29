package edu.poly.shop.service;

import java.util.List;

import edu.poly.shop.entity.Authority;

public interface AuthorityService {

	List<Authority> findAll();

	List<Authority> findAuthoritiesOfAdministrators();

	Authority create(Authority auth);

	void delete(Integer id);

	void save(Authority au);

	

}
