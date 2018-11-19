package com.meetshah.TokenBasedSpringAuthentication.Authentication.models;

import java.util.Optional;

public class ErrorInfo {

	private String code;
	private String message;
	private Optional<String> title;
	private Optional<Object> data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Optional<String> getTitle() {
		return title;
	}

	public void setTitle(Optional<String> title) {
		this.title = title;
	}

	public Optional<Object> getData() {
		return data;
	}

	public void setData(Optional<Object> data) {
		this.data = data;
	}
}
