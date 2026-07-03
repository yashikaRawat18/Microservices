package com.AuthService.AutherService.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.AuthService.AutherService.Repo.RepoRole;
import com.AuthService.AutherService.Model.Roles;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RepoRole repoRole;

    public DataInitializer(RepoRole repoRole) {
        this.repoRole = repoRole;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repoRole.findByName("ROLE_USER").isEmpty()) {
            Roles role = new Roles();
            role.setName("ROLE_USER");
            repoRole.save(role);
            System.out.println("Initialized database with default role: ROLE_USER");
        }
    }
}
