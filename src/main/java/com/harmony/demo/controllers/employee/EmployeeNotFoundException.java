package com.harmony.demo.controllers.employee;

public class EmployeeNotFoundException extends RuntimeException{
    EmployeeNotFoundException(Integer id) {
        super("Could not find employee " + id);
      }
}
