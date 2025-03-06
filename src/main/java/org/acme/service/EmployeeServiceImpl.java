package org.acme.service;

import org.acme.dto.EmployeeDTO;
import org.acme.entity.EmployeeEntity;
import org.acme.repository.EmployeeRepository;
import org.acme.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        for (EmployeeEntity employeeEntity : employeeEntityList) {
            employeeDTOList.add(Util.entityToDto(employeeEntity));
        }

        return employeeDTOList;

    }

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employee) {
        EmployeeEntity addedEmployeeEntity = employeeRepository.save(Util.dtoToEntity(employee));

        return Util.entityToDto(addedEmployeeEntity);
    }

}
