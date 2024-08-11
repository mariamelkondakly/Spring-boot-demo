package com.example.ShoppingCartBackend.repository;

import com.example.ShoppingCartBackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
