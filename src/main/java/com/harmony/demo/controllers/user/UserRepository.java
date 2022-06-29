package com.harmony.demo.controllers.user;

import com.harmony.demo.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User, Long> {

}