package com.dgmf.mapper;

import com.dgmf.dto.EmployeeDtoRequest;
import com.dgmf.dto.EmployeeDtoResponse;
import com.dgmf.entity.Employee;

public class EmployeeMapper {
    public static Employee mapToEmployee(EmployeeDtoRequest employeeDtoRequest) {
        Employee employee = Employee.builder()
                .firstName(employeeDtoRequest.getFirstName())
                .lastName(employeeDtoRequest.getLastName())
                .email(employeeDtoRequest.getEmail())
                .build();

        return employee;
    }

    public static EmployeeDtoResponse mapToEmployeeDtoResponse(Employee employee) {
        EmployeeDtoResponse employeeDtoResponse = EmployeeDtoResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();

        return employeeDtoResponse;
    }
}
