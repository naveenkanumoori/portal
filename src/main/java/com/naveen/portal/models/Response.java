package com.naveen.portal.models;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Response {
	private static final long serialVersionUID = 5926468583005150707L;
	
	private HttpStatus status;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private String message;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private Object data;

	
	public Response(HttpStatus status, String message, Object data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
		
}
