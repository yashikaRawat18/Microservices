package com.AuthService.AutherService.Services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.AuthService.AutherService.Model.Roles;
import com.AuthService.AutherService.Model.Users;
import com.AuthService.AutherService.Repo.RepoRole;
import com.AuthService.AutherService.Repo.UsersRepo;
@Service
public class UsersService {
	@Autowired
	private RepoRole rolesRepo;


	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private UsersRepo usersRepo;
	   
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JWTService jwtService;

	public Users register(Users user) {

	    user.setPassword(encoder.encode(user.getPassword()));

	    Roles roleUser = rolesRepo.findByName("ROLE_USER")
	            .orElseThrow(() -> new RuntimeException("ROLE_USER not found"));

	    user.setRoles(Set.of(roleUser));

	    return usersRepo.save(user);
	}


	public List<Users> getAllUsers(){
		return usersRepo.findAll();
	}


	public String verify(Users user) {
		
		Authentication authentication=authManager
				.authenticate(new UsernamePasswordAuthenticationToken
						(user.getUsername(), user.getPassword()));
						
			if(authentication.isAuthenticated()) {
				return jwtService.generateToken(user.getUsername());
			}
			else 
			  return "fail";
		
	}
}
