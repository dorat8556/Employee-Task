package com.doratias.employeeTask.service.impl;

import com.doratias.employeeTask.aspects.LogExecutionTime;
import com.doratias.employeeTask.model.Address;
import com.doratias.employeeTask.model.Child;
import com.doratias.employeeTask.model.Employee;
import com.doratias.employeeTask.model.Spouse;
import com.doratias.employeeTask.repository.EmployeeRepository;
import com.doratias.employeeTask.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Dor Atias
 */

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AddressService addressService;
    private final ChildService childService;
    private final SpouseService spouseService;
//    private final EmployeeMapper employeeMapper;


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
        return employeeRepository.save(Employee.builder()
                .first_name(employee.getFirst_name())
                .last_name(employee.getLast_name())
                .spouse(createSpouse(employee))
                .addresses(createListOfAddresses(employee))
                .children(createListOfChildren(employee))
                .build());
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
        employeeToUpdate.setLast_name(newLastName);
        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public Employee updateEmployeeAddress(int id, List<Address> addresses) {
        Employee employeeToUpdate = employeeRepository.getById(id);
        employeeToUpdate.setAddresses(addressService.createAddresses(addresses));
        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public Employee updateEmployeeChildren(int id, List<Child> children) {
        Employee employeeToUpdate = employeeRepository.getById(id);
        employeeToUpdate.setChildren(childService.createChildren(children));
        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public Employee updateEmployeeSpouse(int id, Spouse spouse) {
        Employee employeeToUpdate = employeeRepository.getById(id);
        employeeToUpdate.setSpouse(spouseService.createSpouse(spouse));
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
    /*
    Employee entityToUpdate = employeeRepository.getById(employee.getId());
        employeeMapper.updateEmployeeFromDto(employee,entityToUpdate);
        return employeeRepository.save(entityToUpdate);
     */

    private List<Address> createListOfAddresses(Employee employee) {
        return addressService.createAddresses(employee.getAddresses());
    }

    private List<Child> createListOfChildren(Employee employee) {
        return childService.createChildren(employee.getChildren());
    }

    private Spouse createSpouse(Employee employee) {
        return spouseService.createSpouse(employee.getSpouse());
    }
}
