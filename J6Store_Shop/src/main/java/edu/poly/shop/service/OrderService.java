package edu.poly.shop.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import edu.poly.shop.entity.Order;


public interface OrderService {

	Order create(JsonNode orderData);

	Object findById(Long id);

	List<Order> findByUsername(String username);

	List<Order> findAll();

	List<Object> selectMonth();

	List<Object> selectYear();

	

}
