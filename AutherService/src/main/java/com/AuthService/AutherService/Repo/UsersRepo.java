package com.AuthService.AutherService.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AuthService.AutherService.Model.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer>{
	Users findByUsername(String Username);
}
