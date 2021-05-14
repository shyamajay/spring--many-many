package com.example.userproject.entities;

import org.springframework.http.HttpStatus;

public class ProductErrorResponse {

	private HttpStatus status;
	private String message;
	private long timeStamp;

	public ProductErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductErrorResponse(HttpStatus status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	
}
