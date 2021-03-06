package com.ordermanagement.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
public class OrderItem {
	@NotBlank
	private String itemName;
	@Min(value = 0, message = "price should not be less than 0")
	private float price;
	private int quantity;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
