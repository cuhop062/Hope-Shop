package edu.poly.shop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.poly.shop.dao.OrderDao;
import edu.poly.shop.dao.OrderDetailDao;
import edu.poly.shop.entity.Order;
import edu.poly.shop.entity.OrderDetail;
import edu.poly.shop.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderDetailDao ddao;

	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();
		Order order = mapper.convertValue(orderData, Order.class);
		orderDao.save(order);

		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
		};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type).stream()
				.peek(d -> d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);

		return order;
	}

	@Override
	public Object findById(Long id) {
		// TODO Auto-generated method stub
		return orderDao.findById(id).get();// optional
	}

	@Override
	public List<Order> findByUsername(String username) {
		// TODO Auto-generated method stub
		return orderDao.findByUsername(username);
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderDao.findAll();
	}

	@Override
	public List<Object> selectMonth() {
		// TODO Auto-generated method stub
		return orderDao.selectMonth();
	}

	@Override
	public List<Object> selectYear() {
		// TODO Auto-generated method stub
		return orderDao.selectYear();
	}


	

}
