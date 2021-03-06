package com.ordermanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderLine {
	private List<OrderItem> listOfItems;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	private Date eta;
	@Enumerated(EnumType.STRING)
	private OrderLineStatus statusLine;
	private List<Address> addresses;

	public List<OrderItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<OrderItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public OrderLineStatus getStatusLine() {
		return statusLine;
	}

	public void setStatusLine(OrderLineStatus statusLine) {
		this.statusLine = statusLine;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

}
