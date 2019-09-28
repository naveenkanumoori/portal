package com.naveen.portal.models;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

public class AuthResponse {
	private static final long serialVersionUID = 5926468583005150707L;
	
	private HttpStatus status;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private String message;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	private String token;

	public AuthResponse() {
		super();
	}
	
	public AuthResponse(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public AuthResponse(HttpStatus status, String message, String token) {
		this(status, message);
		this.token = token;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
