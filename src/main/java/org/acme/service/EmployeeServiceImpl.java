package org.acme.service;

import lombok.extern.slf4j.Slf4j;
import org.acme.dto.EmployeeDTO;
import org.acme.entity.EmployeeEntity;
import org.acme.repository.EmployeeRepository;
import org.acme.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

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
