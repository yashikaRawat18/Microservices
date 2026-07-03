package com.AuthService.AutherService.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AuthService.AutherService.Model.Roles;
import com.AuthService.AutherService.Model.Users;
@Repository
public interface RepoRole extends JpaRepository<Roles, Integer>{
	  Optional<Roles> findByName(String name);
}
