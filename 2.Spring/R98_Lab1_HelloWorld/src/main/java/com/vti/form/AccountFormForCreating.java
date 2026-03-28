package com.vti.form;

public class AccountFormForCreating {
	private String user;
	private String email;
	private String fullname;

	public String getUser() {
		return user;
	}

	public AccountFormForCreating() {
		super();
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
