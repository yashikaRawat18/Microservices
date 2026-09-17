package com.MicroService.ProductService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MicroService.ProductService.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
