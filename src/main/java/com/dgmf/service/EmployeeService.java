package com.dgmf.service;

import com.dgmf.dto.EmployeeDtoRequest;
import com.dgmf.dto.EmployeeDtoResponse;

public interface EmployeeService {
    EmployeeDtoResponse addEmployee(EmployeeDtoRequest employeeDtoRequest);
}
