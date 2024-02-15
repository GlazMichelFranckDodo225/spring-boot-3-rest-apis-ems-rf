package com.dgmf.service.impl;

import com.dgmf.dto.EmployeeDtoRequest;
import com.dgmf.dto.EmployeeDtoResponse;
import com.dgmf.entity.Employee;
import com.dgmf.exception.ResourceNotFoundException;
import com.dgmf.mapper.EmployeeMapper;
import com.dgmf.repository.EmployeeRepository;
import com.dgmf.service.EmployeeService;
import jakarta.persistence.criteria.From;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDtoResponse addEmployee(EmployeeDtoRequest employeeDtoRequest) {
        Employee employee = employeeMapper.mapToEmployee(employeeDtoRequest);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDtoResponse employeeDtoResponse =
                employeeMapper.mapToEmployeeDtoResponse(savedEmployee);

        return employeeDtoResponse;
    }

    @Override
    public EmployeeDtoResponse getEmployeeById(Long employeeId) {
        Employee employeeFromDb = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee with id " +
                        employeeId + " Not Found"));

                // modelMapper.map(employeeFromDb, EmployeeDtoResponse.class);
        EmployeeDtoResponse employeeDtoResponse =
                // employeeMapper.mapToEmployeeDtoResponse(employeeFromDb);
                employeeMapper.mapToEmployeeDtoResponse(employeeFromDb);


        return employeeDtoResponse;
    }

    @Override
    public List<EmployeeDtoResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

                // employees.forEach(employee -> modelMapper.map(employee, EmployeeDtoResponse.class));
                /*employees.stream().map(
                        employee -> modelMapper.map(employee, EmployeeDtoResponse.class)
                ).collect(Collectors.toList());*/
        List<EmployeeDtoResponse> employeeDtoResponses = employees.stream()
                // .map(employee -> employeeMapper.mapToEmployeeDtoResponse(employee))
                .map(employeeMapper::mapToEmployeeDtoResponse)
                .collect(Collectors.toList());

        return employeeDtoResponses ;
    }

    @Override
    public EmployeeDtoResponse updateEmployee(
            Long employeeId, EmployeeDtoRequest employeeDtoRequest
    ) {
        // Employee From DB
        Employee employeeFromDB = employeeRepository.findById(employeeId)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                        "Employee with the Given Id " +
                                employeeId + " Does Not Exists"
                    )
                );

        // Update Employee
        employeeFromDB.setEmail(employeeDtoRequest.getEmail());
        employeeFromDB.setFirstName(employeeDtoRequest.getFirstName());
        employeeFromDB.setLastName(employeeDtoRequest.getLastName());

        // Save Updated Employee
        Employee updatedEmployee = employeeRepository.save(employeeFromDB);

        // Convert to Dto
        EmployeeDtoResponse employeeDtoResponse = employeeMapper
                .mapToEmployeeDtoResponse(updatedEmployee);

        return employeeDtoResponse;
    }
}
