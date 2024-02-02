package com.dgmf.service.impl;

import com.dgmf.dto.EmployeeDtoRequest;
import com.dgmf.dto.EmployeeDtoResponse;
import com.dgmf.entity.Employee;
import com.dgmf.mapper.EmployeeMapper;
import com.dgmf.repository.EmployeeRepository;
import com.dgmf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDtoResponse addEmployee(EmployeeDtoRequest employeeDtoRequest) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDtoRequest);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDtoResponse employeeDtoResponse =
                EmployeeMapper.mapToEmployeeDtoResponse(savedEmployee);

        return employeeDtoResponse;
    }

    @Override
    public EmployeeDtoResponse getEmployeeById(Long employeeId) {
        Employee employeeFromDb = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee with id " +
                        employeeId + " Not Found"));

        EmployeeDtoResponse employeeDtoResponse =
                modelMapper.map(employeeFromDb, EmployeeDtoResponse.class);

        return employeeDtoResponse;
    }
}
