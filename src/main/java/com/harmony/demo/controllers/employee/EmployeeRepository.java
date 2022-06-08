package com.harmony.demo.controllers.employee;

import com.harmony.demo.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}