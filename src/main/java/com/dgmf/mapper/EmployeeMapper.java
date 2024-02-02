package com.dgmf.mapper;

import com.dgmf.dto.EmployeeDtoRequest;
import com.dgmf.dto.EmployeeDtoResponse;
import com.dgmf.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {
    private final ModelMapper modelMapper;

    public Employee mapToEmployee(EmployeeDtoRequest employeeDtoRequest) {
        /*Employee employee = Employee.builder()
                .firstName(employeeDtoRequest.getFirstName())
                .lastName(employeeDtoRequest.getLastName())
                .email(employeeDtoRequest.getEmail())
                .build();*/

        Employee employee = modelMapper.map(employeeDtoRequest, Employee.class);

        return employee;
    }

    public EmployeeDtoResponse mapToEmployeeDtoResponse(Employee employee) {
        /*EmployeeDtoResponse employeeDtoResponse = EmployeeDtoResponse.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();*/

        EmployeeDtoResponse employeeDtoResponse =
                modelMapper.map(employee, EmployeeDtoResponse.class);

        return employeeDtoResponse;
    }
}
