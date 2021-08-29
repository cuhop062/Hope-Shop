package edu.poly.shop.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import edu.poly.shop.entity.Order;
import edu.poly.shop.entity.OrderDetail;
import edu.poly.shop.model.Report;
import edu.poly.shop.service.OrderDetailService;
import edu.poly.shop.service.OrderService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailService orderDetailService;

	@GetMapping
	public List<Order> getAll() {
		return orderService.findAll();
	}

	@GetMapping(value = "{orderId}")
	public List<OrderDetail> getAmount(@PathVariable Long orderId) {
		return orderDetailService.getAmount(orderId);
	}

	@GetMapping(value = "sum")
	public List<Object> getSumYear() {
		return orderDetailService.getSumYear();
	}

	@GetMapping(value = "month")
	public List<Object> getMonth() {
		return orderService.selectMonth();
	}

	@GetMapping(value = "year")
	public List<Object> getYear() {
		return orderService.selectYear();
	}

	@PostMapping()
	public Order create(@RequestBody JsonNode orderData) {
		return orderService.create(orderData);
	}

	@GetMapping(value = "inventoryByCategory")
	public List<Report> getInventoryByCategory() {
		return orderDetailService.getInventoryByCategory();
	}
	
	@GetMapping(value = "thongke/{year}/{month}")
    public List<OrderDetail> getThongke(@PathVariable Integer month, @PathVariable Integer year) {
        return orderDetailService.getValueByMonthAndYear(year, month);
    }
	
	@GetMapping(value = "thongkeCate/{year}/{month}")
    public Object getCate(@PathVariable Integer month, @PathVariable Integer year) {
        return orderDetailService.getByCateMonthAndYear(year, month);
    }

}
