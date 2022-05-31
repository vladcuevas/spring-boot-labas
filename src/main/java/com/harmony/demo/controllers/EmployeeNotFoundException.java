package com.harmony.demo.controllers;

public class EmployeeNotFoundException extends RuntimeException{
    EmployeeNotFoundException(Integer id) {
        super("Could not find employee " + id);
      }
}
