package org.acme.controller;

import lombok.extern.slf4j.Slf4j;
import org.acme.dto.EmployeeDTO;
import org.acme.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/api")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeDTO> getAllEmployees() {
        log.info("Get all employees");
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employee) {
        log.info("Create a employee {}", employee);
        EmployeeDTO addedEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(addedEmployee);
    }

}
