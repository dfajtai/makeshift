package com.makeshift.makeshift.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.makeshift.makeshift.auth.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Lekérdezés felhasználónév alapján, autentikációhoz szükséges
    Optional<User> findByUsername(String username);
}