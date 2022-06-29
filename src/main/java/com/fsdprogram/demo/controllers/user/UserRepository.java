package com.fsdprogram.demo.controllers.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsdprogram.demo.model.User;

interface UserRepository extends JpaRepository<User, Long> {

}