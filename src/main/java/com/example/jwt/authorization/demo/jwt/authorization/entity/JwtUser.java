package com.example.jwt.authorization.demo.jwt.authorization.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JWT_USER")
public class JwtUser {
	
	@Id
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "PASSWORD")
	private String password;

	public String getUserName() {
		return userName;
	}

	public JwtUser() {
	}

	public JwtUser(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
