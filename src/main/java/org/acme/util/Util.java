package org.acme.util;

import org.acme.dto.EmployeeDTO;
import org.acme.entity.EmployeeEntity;

public class Util {

    public static EmployeeDTO entityToDto(EmployeeEntity employeeEntity) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if (employeeEntity != null) {
            employeeDTO.setId(employeeEntity.getId());
            employeeDTO.setName(employeeEntity.getName());
            employeeDTO.setAge(employeeEntity.getAge());
            employeeDTO.setRole(employeeEntity.getRole());
            return employeeDTO;
        }
        return employeeDTO;
    }

    public static EmployeeEntity dtoToEntity(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        if (employeeDTO != null) {
            employeeEntity.setId(employeeDTO.getId());
            employeeEntity.setName(employeeDTO.getName());
            employeeEntity.setAge(employeeDTO.getAge());
            employeeEntity.setRole(employeeDTO.getRole());
            return employeeEntity;
        }
        return employeeEntity;
    }
}
