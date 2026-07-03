package com.microservice.NotificationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.NotificationService.Model.Orders;
@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer>{

}
