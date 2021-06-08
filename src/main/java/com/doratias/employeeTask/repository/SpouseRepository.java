package com.doratias.employeeTask.repository;

import com.doratias.employeeTask.model.Spouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dor Atias
 */
@Repository
public interface SpouseRepository extends JpaRepository<Spouse, Integer> {
}
