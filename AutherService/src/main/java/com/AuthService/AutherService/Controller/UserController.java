package com.AuthService.AutherService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.AuthService.AutherService.Model.Users;
import com.AuthService.AutherService.Services.UsersService;

@RestController
public class UserController {
	
	@Autowired
	private UsersService service;
	 
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return service.register(user); 
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		return service.verify(user);
	}
	

}
