package com.dgmf.service.impl;

import com.dgmf.dto.EmployeeDtoRequest;
import com.dgmf.dto.EmployeeDtoResponse;
import com.dgmf.entity.Employee;
import com.dgmf.mapper.EmployeeMapper;
import com.dgmf.repository.EmployeeRepository;
import com.dgmf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDtoResponse addEmployee(EmployeeDtoRequest employeeDtoRequest) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDtoRequest);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDtoResponse employeeDtoResponse =
                EmployeeMapper.mapToEmployeeDtoResponse(savedEmployee);

        return employeeDtoResponse;
    }
}
