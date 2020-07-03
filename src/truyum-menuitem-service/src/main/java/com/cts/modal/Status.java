package com.cts.modal;

public class Status {

	public Status() {
		super();
	}
	public Status(String token, boolean validUser) {
		super();
		this.token = token;
		this.validUser = validUser;
	}
	private String token;
	private boolean validUser;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean getValidUser() {
		return validUser;
	}
	public void setValidUser(boolean validUser) {
		this.validUser = validUser;
	}
	@Override
	public String toString() {
		return "Status [token=" + token + ", validUser=" + validUser + "]";
	}
}
