package com.AuthService.AutherService.Services;

import java.nio.file.attribute.UserPrincipal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.AuthService.AutherService.Model.Users;
import com.AuthService.AutherService.Repo.UserPrinciple;
import com.AuthService.AutherService.Repo.UsersRepo;

@Service
public class AuthUserDetailService implements UserDetailsService {
	
	@Autowired
	private UsersRepo repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user=repo.findByUsername(username);
		
		if(user==null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		return  new UserPrinciple(user);
	}

}
