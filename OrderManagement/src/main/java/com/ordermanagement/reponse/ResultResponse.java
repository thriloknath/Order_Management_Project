package com.ordermanagement.reponse;

public class ResultResponse {
	private int responseCode;
	private String message;

	public ResultResponse() {
	}

	public ResultResponse(int responseCode, String message) {
		this.responseCode = responseCode;
		this.message = message;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
