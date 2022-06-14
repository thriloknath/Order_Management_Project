package com.ordermanagement.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "orderLine")
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	@OneToMany
	@JoinColumn(name = "orderLine_id")
	private List<OrderItem> items;
	private Date eta;
	private OrderLineStatus statusLine;
	@OneToMany
	@JoinColumn(name = "address_id")
	private List<Address> addresses;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
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
