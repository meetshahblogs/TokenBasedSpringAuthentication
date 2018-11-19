package com.meetshah.TokenBasedSpringAuthentication.Authentication.models;

public class AuthenticationInfo {

	private boolean authenticated;

	public AuthenticationInfo(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
}
