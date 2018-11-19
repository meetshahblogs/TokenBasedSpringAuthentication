package com.meetshah.TokenBasedSpringAuthentication.Authentication;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.meetshah.TokenBasedSpringAuthentication.Authentication.models.AuthException;
import com.meetshah.TokenBasedSpringAuthentication.Authentication.models.AuthenticationInfo;

@Service
public class AuthenticationClient {

	public AuthenticationInfo authenticateUser(String username, String password) {

		if (username.equalsIgnoreCase("meet.shah") && password.equals("password1")) {
			return new AuthenticationInfo(true);
		} else {
			throw new AuthException(HttpServletResponse.SC_UNAUTHORIZED, "auth.credentials.invalid");
		}
	}
}
