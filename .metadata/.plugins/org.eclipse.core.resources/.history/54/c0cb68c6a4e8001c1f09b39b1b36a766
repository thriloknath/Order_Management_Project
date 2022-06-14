package com.ordermanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermanagement.model.Order;
import com.ordermanagement.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
 
	@Autowired
	OrderService orderService;
	
	@GetMapping("/{id}")
	ResponseEntity<Optional<Order>> getOrder(@PathVariable int id) {
		Optional<Order> order = orderService.getOrderById(id);
		if (order.isPresent()) {
			return ResponseEntity.ok(order);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/*
	 * @GetMapping("pin/{pincode}") ResponseEntity<List<Order>>
	 * getListOfStoreDetails(@PathVariable String pincode) { List<Order> orders =
	 * orderService.getOrderByPincode(pincode); if (orders.size() > 0) { return
	 * ResponseEntity.ok(orders); } else { return ResponseEntity.notFound().build();
	 * } }
	 */
	@PostMapping
	public ResponseEntity<Order> postStoreDetails(@RequestBody Order order) {
		Order orders = orderService.saveOrder(order);
		return ResponseEntity.ok(orders);
	}

}
