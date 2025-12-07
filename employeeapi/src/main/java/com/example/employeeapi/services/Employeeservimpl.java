package com.example.employeeapi.services;

import com.example.employeeapi.dto.Employeedto;
import com.example.employeeapi.entity.Employee;
import org.springframework.stereotype.Service;
import com.example.employeeapi.mapper.EmployeeMapper;
import com.example.employeeapi.repository.Employeerepo;
import java.util.List;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Employeeservimpl implements Employeeservice {
    private Employeerepo employeerepo;

    @Override
    public Employeedto createEmployee(Employeedto employeedto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeedto);
        Employee createEmployee = employeerepo.save(employee);
        return EmployeeMapper.mapToEmployeedto(createEmployee);
    }

    @Override
    public Employeedto getEmployee(Long employeeId) {
        Employee employee = employeerepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return EmployeeMapper.mapToEmployeedto(employee);
    }

    @Override
    public List<Employeedto> getAllEmployees() {
        List<Employee> employees = employeerepo.findAll();
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeedto)
                .toList();
    }

    @Override
    public Employeedto updateEmployee(Long employeeId, Employeedto employeedto) {
        Employee existingEmployee = employeerepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployee.setName(employeedto.getName());
        existingEmployee.setRole(employeedto.getRole());
        existingEmployee.setEmail(employeedto.getEmail());

        Employee updatedEmployee = employeerepo.save(existingEmployee);
        return EmployeeMapper.mapToEmployeedto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee existingEmployee = employeerepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeerepo.delete(existingEmployee);
    }
}