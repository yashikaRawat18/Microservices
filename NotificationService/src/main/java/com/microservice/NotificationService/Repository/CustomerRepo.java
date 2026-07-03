package com.microservice.NotificationService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.NotificationService.Model.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	public Customer findByEmail(String emial);
}
