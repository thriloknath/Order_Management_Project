package com.ordermanagement.reponse;

import com.ordermanagement.model.Order;

public class OrderResult extends ResultResponse {
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
