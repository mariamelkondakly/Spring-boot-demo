package com.example.ShoppingCartBackend.controller;

import com.example.ShoppingCartBackend.model.Employee;
import com.example.ShoppingCartBackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //build get all employees
    @GetMapping
    public List<Employee>getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //Build get employee by id\
    @GetMapping("{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable("id") long id){
      return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK) ;
    }

    //Build put employee by id
    @PutMapping("{id}")
    public ResponseEntity<Employee>UpdateExistingEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }

    //Build delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<String>deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
    }
}
