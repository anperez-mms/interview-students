package org.acme.service;

import java.util.List;

import org.acme.dto.EmployeeDTO;

public interface EmployeeService {

	public List<EmployeeDTO> getAllEmployees();

	public EmployeeDTO addEmployee(EmployeeDTO employee);

}
