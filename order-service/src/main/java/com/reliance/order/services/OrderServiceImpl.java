package com.reliance.order.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reliance.order.model.OrderDetails;
import com.reliance.order.exception.OrderNotFoundException;
import com.reliance.order.repository.OrderRepository;



@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;


	@Override
	public List<OrderDetails> getOrders() {
		List<OrderDetails> orders = orderRepository.findAll();
		return orders;
	}

	@Override
	public OrderDetails getOrder(int id) {
		Optional<OrderDetails> order = orderRepository.findById(id);
		if(!order.isPresent()) {
			System.out.println("order does not exist in the database!");
			throw new OrderNotFoundException("order does not exist in the database!");
		} else {
			return order.get();
		}
	}

	@Override
	public OrderDetails createOrder(OrderDetails order) {
		OrderDetails dbOrder = orderRepository.save(order);
		return dbOrder;
	}

	@Override
	public OrderDetails updateOrder(Integer id, OrderDetails order) {
		Optional<OrderDetails> dbOrder = orderRepository.findById(id);
		if(!dbOrder.isPresent()) {
			System.out.println("Order does not exist in the database!");
			throw new OrderNotFoundException("Order does not exist in the database!");
		} else {
			OrderDetails toBeUpdated = dbOrder.get();
			toBeUpdated.setDescription(order.getDescription());
			toBeUpdated.setDate(order.getDate());
			OrderDetails updatedOrder = orderRepository.save(toBeUpdated);
			return updatedOrder;
		}
	}

	@Override
	public void deleteOrder(Integer id) {
		Optional<OrderDetails> dbOrder = orderRepository.findById(id);
		if (dbOrder.isPresent()) {
			orderRepository.delete(dbOrder.get());	
			System.out.println("Order has been deleted: " + id);
		} else {
			System.out.println("Order Not Found!");
			throw new OrderNotFoundException("Order does not exist in the database!");
		}	
		
	}

}
