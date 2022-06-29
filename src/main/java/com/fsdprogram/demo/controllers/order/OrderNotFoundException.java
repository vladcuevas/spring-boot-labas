package com.fsdprogram.demo.controllers.order;

public class OrderNotFoundException extends RuntimeException{
    OrderNotFoundException(Long id) {
        super("Could not find user " + id);
      }
}
