package com.MicroService.OrderService.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MicroService.OrderService.Model.Customer;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	Optional<Customer> findByEmail(String emial);
}
