package com.doratias.employeeTask.service.impl;

import com.doratias.employeeTask.aspects.LogExecutionTime;
import com.doratias.employeeTask.model.Address;
import com.doratias.employeeTask.model.Child;
import com.doratias.employeeTask.model.Employee;
import com.doratias.employeeTask.model.Spouse;
import com.doratias.employeeTask.repository.EmployeeRepository;
import com.doratias.employeeTask.service.AddressService;
import com.doratias.employeeTask.service.ChildService;
import com.doratias.employeeTask.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dor Atias
 */

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AddressService addressService;
    private final ChildService childService ;
//    private final EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    @LogExecutionTime
    public Employee getEmployee(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployeeFirstName(int id, String newFirstName) {

    }

    @Override
    public void updateEmployeeLastName(int id, String newLastName) {

    }

//    @Override
//    public void updateAddress(int id, Address address) {
//
//    }
//
//    @Override
//    public void updateChildren(int id, Child child) {
//
//    }
//
//    @Override
//    public void updateSpouse(int id, Spouse spouse) {
//
//    }
}
