package com.doratias.employeeTask.repository;

import com.doratias.employeeTask.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dor Atias
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
//  EXAMPLE
//    Employee findByFirst_name();
}
