package edu.poly.shop.service;

import java.util.List;

import edu.poly.shop.entity.OrderDetail;
import edu.poly.shop.model.Report;

public interface OrderDetailService {

	List<Object> getSumYear();

	List<OrderDetail> getValueByMonthAndYear(Integer year, Integer month);

	List getByCateMonthAndYear(Integer year, Integer month);

	List<OrderDetail> getAmount(Long orderId);

	List<OrderDetail> findTop10ByOrderByQuantityDesc();

	List<Report> getInventoryByCategory();

	List<OrderDetail> findAll();

}
