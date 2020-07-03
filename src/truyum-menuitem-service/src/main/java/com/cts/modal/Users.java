package com.cts.modal;

public class Users {

	public Users() {
		super();
	}
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
