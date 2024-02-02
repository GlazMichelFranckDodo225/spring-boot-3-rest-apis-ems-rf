package com.dgmf.controller;

import com.dgmf.dto.EmployeeDtoRequest;
import com.dgmf.dto.EmployeeDtoResponse;
import com.dgmf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    // Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDtoResponse> addEmployee(
            @RequestBody EmployeeDtoRequest employeeDtoRequest
            ) {
        return new ResponseEntity<>(
                employeeService.addEmployee(employeeDtoRequest),
                HttpStatus.CREATED
        );
    }

    // Get Employee REST API
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDtoResponse> getEmployee(
            @PathVariable("id") Long employeeId
    ) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }
}
