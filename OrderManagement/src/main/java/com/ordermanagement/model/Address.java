package com.ordermanagement.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Address {
	@Min(value = 6, message = "6-digit pin is reuired")
	private int pinCode;
	@NotEmpty
	private String state;
	@NotEmpty
	private String country;

	

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}