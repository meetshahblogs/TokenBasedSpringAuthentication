package com.meetshah.TokenBasedSpringAuthentication.SecurityConfiguration;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meetshah.TokenBasedSpringAuthentication.Authentication.models.AuthException;
import com.meetshah.TokenBasedSpringAuthentication.Authentication.models.ErrorInfo;

@Component
public class AuthEntryPoint implements AuthenticationEntryPoint {

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		int statusCode;
		String messageCode;
		if (authException instanceof AuthException) {
			statusCode = ((AuthException) authException).getStatusCode();
			messageCode = ((AuthException) authException).getMessage();
		} else {
			statusCode = HttpServletResponse.SC_UNAUTHORIZED;
			messageCode = "auth.required";
		}

		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setCode(messageCode);
		errorInfo.setData(Optional.empty());
		errorInfo.setTitle(Optional.of("We're sorry!"));

		String jsonResponse = objectMapper.writeValueAsString(errorInfo);

		response.setStatus(statusCode);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.getWriter().write(jsonResponse);
	}

}
