package com.makeshift.makeshift.auth.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.makeshift.makeshift.auth.model.Role;
import com.makeshift.makeshift.auth.model.User;
import com.makeshift.makeshift.auth.repository.UserRepository;

@Configuration
public class SuperAdminInitializer {

    @Value("${superadmin.username}")
    private String superAdminUsername;

    @Value("${superadmin.password}")
    private String superAdminPassword;

    @Value("${superadmin.enabled:true}")
    private boolean superAdminEnabled;

    @Value("${superadmin.roles:ROLE_ADMIN,ROLE_SUPERADMIN}")
    private String superAdminRoles;

    @Bean
    public ApplicationRunner initSuperAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            boolean exists = userRepository.findByUsername(superAdminUsername).isPresent();
            if (!exists) {
                User superAdmin = new User();
                superAdmin.setUsername(superAdminUsername);
                superAdmin.setPassword(passwordEncoder.encode(superAdminPassword));
                superAdmin.setEnabled(superAdminEnabled);

                // Szerepkörök parsing-ja enum értékekké
                Set<Role> roles = new HashSet<>();
                Arrays.stream(superAdminRoles.split(","))
                        .map(String::trim)
                        .map(Role::valueOf)
                        .forEach(roles::add);
                superAdmin.setRoles(roles);

                userRepository.save(superAdmin);
                System.out.println("[INIT] Superadmin user created: " + superAdminUsername);
            } else {
                System.out.println("[INIT] Superadmin user already exists: " + superAdminUsername);
            }
        };
    }
}
