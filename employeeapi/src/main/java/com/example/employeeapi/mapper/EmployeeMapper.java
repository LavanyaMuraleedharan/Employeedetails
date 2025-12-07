package com.example.employeeapi.mapper;

import com.example.employeeapi.dto.Employeedto;
import com.example.employeeapi.entity.Employee;

public class EmployeeMapper {

    public static Employeedto mapToEmployeedto(Employee employee) {
        return new Employeedto(
                employee.getId(),
                employee.getName(),

                employee.getRole(),
                employee.getEmail());
    }

    public static Employee mapToEmployee(Employeedto dto) {
        return new Employee(
                dto.getId(),
                dto.getName(),
                dto.getRole(),
                dto.getEmail());
    }
}
