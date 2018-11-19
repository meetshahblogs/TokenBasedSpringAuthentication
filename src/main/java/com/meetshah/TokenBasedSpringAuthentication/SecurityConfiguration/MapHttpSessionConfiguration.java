package com.meetshah.TokenBasedSpringAuthentication.SecurityConfiguration;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.session.web.http.HttpSessionIdResolver;

@Configuration
@EnableSpringHttpSession
// @Profile("dev")
public class MapHttpSessionConfiguration {

	@Bean
	public MapSessionRepository sessionRepository() {
		MapSessionRepository sessionRepository = new MapSessionRepository(new ConcurrentHashMap<>());
		sessionRepository.setDefaultMaxInactiveInterval(30);
		return sessionRepository;
	}

	@Bean
	public HttpSessionIdResolver httpSessionIdResolver() {
		return HeaderHttpSessionIdResolver.xAuthToken();
	}
}
