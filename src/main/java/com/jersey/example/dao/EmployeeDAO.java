package com.jersey.example.dao;

import com.jersey.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
    Employee findEmployeeByName(String name);
}
