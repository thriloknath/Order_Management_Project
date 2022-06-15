package com.ordermanagement.reponse;

import java.util.List;

import com.ordermanagement.model.Order;

public class OrderListResult extends ResultResponse {

	private List<Order> listOfOrders;

	public List<Order> getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}

}
