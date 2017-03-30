package com.RFIDSystem.ws.structures.request;

public class LoginRequest {
	
	public String user;
	public String password;
	
	public LoginRequest() {}
	
	public LoginRequest(String user, String passsword) {
		this.user = user;
		this.password = passsword;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPasssword() {
		return password;
	}
	public void setPasssword(String passsword) {
		this.password = passsword;
	}

	

}
