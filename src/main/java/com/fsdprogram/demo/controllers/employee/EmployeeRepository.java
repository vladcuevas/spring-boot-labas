package com.fsdprogram.demo.controllers.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fsdprogram.demo.model.Employee;

@Repository("EmployeeRepository")
interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByNameContaining(@Param("name") String name);

}