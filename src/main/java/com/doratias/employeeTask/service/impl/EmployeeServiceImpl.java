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
import com.doratias.employeeTask.service.SpouseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private final SpouseService spouseService ;


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
    @Transactional
    @LogExecutionTime
    public Employee createEmployee(Employee employee) {
        Employee newEmployee = new Employee();
        newEmployee.setFirst_name(employee.getFirst_name());
        newEmployee.setLast_name(employee.getLast_name());
        newEmployee.setSpouse(createSpouse(employee));
        newEmployee.setAddresses(createListOfAddresses(employee));
        newEmployee.setChildren(createListOfChildren(employee));
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployeeFirstName(int id, String newFirstName) {
        Employee employeeToUpdate = employeeRepository.getById(id);
        employeeToUpdate.setFirst_name(newFirstName);
        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public Employee updateEmployeeLastName(int id, String newLastName) {
        Employee employeeToUpdate = employeeRepository.getById(id);
        employeeToUpdate.setFirst_name(newLastName);
        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public Employee replaceEmployee(int id, Employee employee) {
        Employee employeeToReplace = employeeRepository.getById(id);
        employeeToReplace.setFirst_name(employee.getFirst_name());
        employeeToReplace.setLast_name(employee.getLast_name());
        employeeToReplace.setAddresses(createListOfAddresses(employee));
        employeeToReplace.setSpouse(createSpouse(employee));
        employeeToReplace.setChildren(createListOfChildren(employee));
        return employeeRepository.save(employeeToReplace);
    }

    private List<Address> createListOfAddresses(Employee employee){
        List<Address> addresses = new ArrayList<>();
        if (employee.getAddresses().size() > 1) {
            addresses = addressService.createAddresses(employee.getAddresses());
        } else {
            addresses.add(addressService.createAddress(employee.getAddresses().get(0)));
        }
        return addresses;
    }

    private List<Child> createListOfChildren(Employee employee){
        List<Child> childrenList = new ArrayList<>();
        if(employee.getChildren().size() > 1){
            childrenList = childService.createChildren(employee.getChildren());
        }else {
            childrenList.add(childService.createChild(employee.getChildren().get(0)));
        }
        return childrenList;
    }

    private Spouse createSpouse(Employee employee){
        return spouseService.createSpouse(employee.getSpouse());
    }
}
