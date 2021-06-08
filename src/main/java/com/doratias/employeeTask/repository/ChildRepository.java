package com.doratias.employeeTask.repository;

import com.doratias.employeeTask.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dor Atias
 */
@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {
}
