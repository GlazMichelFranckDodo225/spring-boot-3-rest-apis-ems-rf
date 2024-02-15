package com.dgmf.controller;

import com.dgmf.dto.EmployeeDtoRequest;
import com.dgmf.dto.EmployeeDtoResponse;
import com.dgmf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDtoResponse>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // Update Employee REST API
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDtoResponse> updateEmployee(
            @PathVariable("id") Long employeeId,
            @RequestBody EmployeeDtoRequest employeeDtoRequest
    ) {
        return ResponseEntity.ok(
                employeeService.updateEmployee(employeeId, employeeDtoRequest)
        );
    }
}
