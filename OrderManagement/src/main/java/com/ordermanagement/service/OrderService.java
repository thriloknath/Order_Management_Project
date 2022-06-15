package com.ordermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordermanagement.model.Order;
import com.ordermanagement.reponse.MessageResponse;
import com.ordermanagement.reponse.OrderListResult;
import com.ordermanagement.reponse.OrderResult;
import com.ordermanagement.reponse.ResultResponse;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;

	public OrderResult getOrderById(String id) {
		OrderResult orderResult = new OrderResult();
		Optional<Order> result = orderRepository.findById(id);
		if (result.get() != null) {
			orderResult.setResponseCode(200);
			orderResult.setMessage(MessageResponse.RETRIVAL_SUCCUSS);
			orderResult.setOrder(result.get());
		} else {
			orderResult.setResponseCode(404);
			orderResult.setMessage(MessageResponse.NOT_FOUND);
		}
		return orderResult;
	}

	public OrderListResult getOrderByPincode(int pincode) {
		List<Order> listOfOrders = orderRepository.findByZipCode(pincode);
		OrderListResult listResult = new OrderListResult();
		if (!listOfOrders.isEmpty()) {
			listResult.setResponseCode(200);
			listResult.setMessage(MessageResponse.RETRIVAL_SUCCUSS);
			listResult.setListOfOrders(listOfOrders);
		} else {
			listResult.setResponseCode(404);
			listResult.setMessage(MessageResponse.NOT_FOUND);
		}
		return listResult;
	}

	public ResultResponse saveOrder(Order order) {
		orderRepository.save(order);
		return new ResultResponse(201, MessageResponse.SAVE_SUCCESFULL);
	}
}
