package org.acme.repository;

import org.acme.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}

