package com.doratias.employeeTask.service;

import com.doratias.employeeTask.model.Address;
import com.doratias.employeeTask.model.Child;
import com.doratias.employeeTask.model.Employee;
import com.doratias.employeeTask.model.Spouse;

import java.util.List;

/**
 * @author Dor Atias
 */
public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployee(int id);

    Employee createEmployee(Employee employee);

    Employee replaceEmployee(int id, Employee employee);

    Employee updateEmployeeFirstName(int id, String newFirstName);

    Employee updateEmployeeLastName(int id, String newLastName);

    void deleteEmployeeById(int id);

//    void updateAddress(int id, Address address);
//
//    void updateChildren(int id , Child child);
//
//    void updateSpouse(int id , Spouse spouse);



}
