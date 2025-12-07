package com.example.employeeapi.services;

import java.util.List;

import com.example.employeeapi.dto.Employeedto;

public interface Employeeservice {
    Employeedto createEmployee(Employeedto employeedto);

    Employeedto getEmployee(Long employeeId);

    List<Employeedto> getAllEmployees();

    Employeedto updateEmployee(Long employeeId, Employeedto employeedto);

    void deleteEmployee(Long employeeId);
}
