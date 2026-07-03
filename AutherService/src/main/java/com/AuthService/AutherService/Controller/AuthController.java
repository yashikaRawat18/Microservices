package com.AuthService.AutherService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AuthService.AutherService.Model.Roles;
import com.AuthService.AutherService.Model.Users;
import com.AuthService.AutherService.Services.UsersService;

@RestController
public class AuthController {
	@Autowired
	private UsersService services;
	@GetMapping("/home")
	public String welcome() {
		return "welocme";
	}
	
	@GetMapping("/getuser")
	public List<Users> getAllUsers(){
		return services.getAllUsers();
	}
	
}
