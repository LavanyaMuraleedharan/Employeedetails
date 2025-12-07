package com.example.employeeapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeeapi.dto.Employeedto;
import com.example.employeeapi.services.Employeeservice;
import org.springframework.web.bind.annotation.PutMapping;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

@CrossOrigin(origins = "http://localhost:5173")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final Employeeservice employeeservice;

    @PostMapping
    public ResponseEntity<Employeedto> createEmployee(@RequestBody Employeedto employeedto) {
        Employeedto createdEmployee = employeeservice.createEmployee(employeedto);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")

    public ResponseEntity<Employeedto> getEmployee(@PathVariable("id") Long id) {
        Employeedto employeedto = employeeservice.getEmployee(id);
        return new ResponseEntity<>(employeedto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employeedto>> getAllEmployees() {
        List<Employeedto> employees = employeeservice.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employeedto> updateEmployee(@PathVariable("id") Long id,
            @RequestBody Employeedto employeedto) {
        Employeedto updatedEmployee = employeeservice.updateEmployee(id, employeedto);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeservice.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
