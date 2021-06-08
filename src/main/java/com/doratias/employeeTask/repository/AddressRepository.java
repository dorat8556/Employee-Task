package com.doratias.employeeTask.repository;

import com.doratias.employeeTask.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dor Atias
 */

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
