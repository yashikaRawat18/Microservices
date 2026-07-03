package com.AuthService.AutherService.Repo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.AuthService.AutherService.Model.Roles;
import com.AuthService.AutherService.Model.Users;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserPrinciple implements UserDetails{

	private Users user;
	public UserPrinciple(Users user) {
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authority=new ArrayList<>();
		for(Roles role:user.getRoles()) {
			authority.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authority;
		
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

}
