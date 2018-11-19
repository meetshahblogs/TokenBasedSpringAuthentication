package com.meetshah.TokenBasedSpringAuthentication.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetshah.TokenBasedSpringAuthentication.UserInfo.models.UserInfo;

@RestController
public class UserController {

	/*
	 * Protected by authentication "principal.authenticated"
	 */
	@GetMapping("api/getUserInfo")
	public UserInfo getUserInfo() {
		return new UserInfo("Meet", "Shah");
	}

	@GetMapping("api/getUser")
	public UserInfo getUser() {
		return new UserInfo("Meet", null);
	}

}
