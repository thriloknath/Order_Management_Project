package com.ordermanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagement.model.Order;
import com.ordermanagement.reponse.OrderListResult;
import com.ordermanagement.reponse.OrderResult;
import com.ordermanagement.reponse.ResultResponse;
import com.ordermanagement.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService orderService;

	@GetMapping("/{id}")
	public OrderResult getOrder(@PathVariable String id) {
		return orderService.getOrderById(id);
	}

	@GetMapping("pin/{pincode}")
	public OrderListResult getListOfOrderDetailsByPincode(@PathVariable int pincode) {
		return orderService.getOrderByPincode(pincode);
	}

	@PostMapping
	public ResultResponse postOrderDetails(@Valid @RequestBody Order orders) {
		return orderService.saveOrder(orders);
	}
}
