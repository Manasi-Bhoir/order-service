package com.reliance.order.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reliance.order.model.OrderDetails;


public interface OrderRepository extends JpaRepository<OrderDetails, Integer>{

}
