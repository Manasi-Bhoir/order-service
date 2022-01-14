package com.reliance.order.services;

import java.util.List;

import com.reliance.order.model.OrderDetails;

public interface OrderService {

	List<OrderDetails> getOrders();

	OrderDetails getOrder(int id);

	OrderDetails createOrder(OrderDetails order);

	OrderDetails updateOrder(Integer id, OrderDetails order);

	void deleteOrder(Integer id);
	


}
