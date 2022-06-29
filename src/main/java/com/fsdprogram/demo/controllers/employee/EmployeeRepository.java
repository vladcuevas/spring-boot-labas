package com.fsdprogram.demo.controllers.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsdprogram.demo.model.Employee;

interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}