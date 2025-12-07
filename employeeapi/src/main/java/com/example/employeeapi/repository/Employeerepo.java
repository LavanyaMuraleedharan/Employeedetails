package com.example.employeeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employeeapi.entity.Employee;

public interface Employeerepo extends JpaRepository<Employee, Long> {

}
