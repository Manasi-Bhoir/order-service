package com.reliance.order.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reliance.order.model.OrderDetails;
import com.reliance.order.services.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	private OrderService orderService ;
	
	@GetMapping("/orders")
	public List<OrderDetails> getOrders() {
		List<OrderDetails> orders = orderService.getOrders();
		return orders;
	}
	
	@GetMapping(path="/orders/{id}")
	public OrderDetails getOrderDetail(@PathVariable("id") int id) {
		return orderService.getOrder(id);
	}
	
	@PostMapping("/orders")
	public OrderDetails createOrder(@RequestBody OrderDetails order) {
		return orderService.createOrder(order);
	}
	
	@PutMapping("/orders/{id}")
	public OrderDetails updateOrder(@PathVariable("id") Integer id, @RequestBody OrderDetails order ) {
		return orderService.updateOrder(id, order);
	}
	
	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable("id") Integer id) {
		orderService.deleteOrder(id);	
	}
	

}
