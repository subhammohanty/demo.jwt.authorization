package com.example.jwt.authorization.demo.jwt.authorization.model;

public class JwtResponse {
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public JwtResponse(String token) {
		super();
		this.token = token;
	}
	
	public JwtResponse() {
	}
	

}
