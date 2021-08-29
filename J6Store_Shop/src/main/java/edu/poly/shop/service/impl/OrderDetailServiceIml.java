package edu.poly.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.shop.dao.OrderDetailDao;
import edu.poly.shop.entity.OrderDetail;
import edu.poly.shop.model.Report;
import edu.poly.shop.service.OrderDetailService;

@Service
public class OrderDetailServiceIml implements OrderDetailService{
	@Autowired
	OrderDetailDao dao;

	@Override
	public List<OrderDetail> findTop10ByOrderByQuantityDesc() {
		return dao.findTop10ByOrderByQuantityDesc();
	}

	@Override
	public List<OrderDetail> getAmount(Long orderId) {
		return dao.getAmount(orderId);
	}

	@Override
	public List getByCateMonthAndYear(Integer year, Integer month) {
		return dao.getByCateMonthAndYear(year, month);
	}

	@Override
	public List<OrderDetail> getValueByMonthAndYear(Integer year, Integer month) {
		return dao.getValueByMonthAndYear(year, month);
	}

	@Override
	public List<Object> getSumYear() {
		return dao.getSumYear();
	}

	@Override
	public List<Report> getInventoryByCategory() {
		// TODO Auto-generated method stub
		return dao.getInventoryByCategory();
	}

	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	
}
