package com.fsdprogram.demo.controllers.user;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(Long id) {
        super("Could not find user " + id);
      }
}
