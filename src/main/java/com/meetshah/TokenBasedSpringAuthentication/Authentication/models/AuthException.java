package com.meetshah.TokenBasedSpringAuthentication.Authentication.models;

import org.springframework.security.core.AuthenticationException;

public class AuthException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	private int statusCode;

	public AuthException(int statusCode, String messageCode) {
		super(messageCode);
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
