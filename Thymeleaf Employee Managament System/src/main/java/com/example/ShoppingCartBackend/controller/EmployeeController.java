package com.example.ShoppingCartBackend.controller;

import com.example.ShoppingCartBackend.model.Employee;
import com.example.ShoppingCartBackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String listEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        return "employees";
    }
    @GetMapping("/employees/new")
    public String createNewStudentForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee", employee);

        return "create_employee";
    }
    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model){
        Employee employee=new Employee();
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit_employee";
    }
    @GetMapping("/employees/{id}")
    public String deleteEmployeeForm(@PathVariable Long id, Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @PostMapping("/employees/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("employee")Employee employee,Model model){
        Employee existingEmployee=employeeService.getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeService.updateEmployee(employee,id);
        return "redirect:/employees";
    }

}
