package com.fsdprogram.demo.controllers.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsdprogram.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}