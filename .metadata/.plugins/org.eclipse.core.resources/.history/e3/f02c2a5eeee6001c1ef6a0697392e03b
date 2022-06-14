package com.ordermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.model.Order;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public Optional<Order> getOrderById(int id) {
		return orderRepository.findById(id);
	}

	public List<Order> getOrderByPincode(String pincode) {
		return orderRepository.findByPincode(pincode);
	}

	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
}
