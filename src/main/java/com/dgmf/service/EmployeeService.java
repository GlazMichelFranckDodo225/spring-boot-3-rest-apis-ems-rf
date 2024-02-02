package com.dgmf.service;

import com.dgmf.dto.EmployeeDtoRequest;
import com.dgmf.dto.EmployeeDtoResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeDtoResponse addEmployee(EmployeeDtoRequest employeeDtoRequest);
    EmployeeDtoResponse getEmployeeById(Long employeeId);
    List<EmployeeDtoResponse> getAllEmployees();
}
