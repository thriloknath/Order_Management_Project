package com.ordermanagement.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordermanagement.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
	public List<Order> findByPincode(String pincode);
}
