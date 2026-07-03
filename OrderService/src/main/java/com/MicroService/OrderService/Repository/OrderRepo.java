package com.MicroService.OrderService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MicroService.OrderService.Model.Order;
@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{
	List<Order> findByCustomerId(Integer customerId);
}
