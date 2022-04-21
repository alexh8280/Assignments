package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
        @Autowired
        EmployeeService empService;
        
        @PostMapping("/employees")
        public Employee createEmployee(@RequestBody Employee emp) {
            return empService.createEmployee(emp);
        }
        
        @GetMapping("/employees")
        public List<Employee> readEmployees() {
            return empService.getEmployees();
        }

        @PatchMapping("/employees/{empId}")
        public Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
            return empService.updateEmployee(id, empDetails);
        }

        @DeleteMapping("/employees/{empId}")
        public void deleteEmployees(@PathVariable(value = "empId") Long id) {
            empService.deleteEmployee(id);
        }


}
