package com.doratias.employeeTask.cotroller;

import com.doratias.employeeTask.model.Address;
import com.doratias.employeeTask.model.Child;
import com.doratias.employeeTask.model.Employee;
import com.doratias.employeeTask.model.Spouse;
import com.doratias.employeeTask.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


/**
 * @author Dor Atias
 */

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
//@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(value = "/{id}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        } else {
            employee.add(linkTo(EmployeeController.class).slash(employee.getId()).withSelfRel());
            return ResponseEntity.ok(employee);
        }
    }

    @GetMapping("/")
    CollectionModel<Employee> getEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();
        for (Employee employee : employeeList) {
            Link selfLink = linkTo(EmployeeController.class).slash(employee.getId()).withSelfRel();
            employee.add(selfLink);
        }
        Link link = linkTo(EmployeeController.class).withSelfRel();
        return CollectionModel.of(employeeList, link);
    }

    @PostMapping("/add-employee")
    EntityModel<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.createEmployee(employee);
        Link selfLink = linkTo(methodOn(EmployeeController.class).getEmployeeById(newEmployee.getId())).withSelfRel();
        return EntityModel.of(newEmployee.add(selfLink));
    }

    @PutMapping("/replace-employee/{id}")
    EntityModel<Employee> replaceEmployee(@RequestBody Employee employee, @PathVariable("id") int id) {
        return EntityModel.of(employeeService.replaceEmployee(id, employee));
    }

    @PatchMapping("/update-first-name/{id}")
    EntityModel<Employee> updateEmployeeFirstName(@PathVariable("id") int id, @RequestBody String first_name) {
        return EntityModel.of(employeeService.updateEmployeeFirstName(id, first_name));
    }

    @PatchMapping("/update-last-name/{id}")
    EntityModel<Employee> updateEmployeeLastName(@PathVariable("id") int id, @RequestBody String last_name) {
        return EntityModel.of(employeeService.updateEmployeeLastName(id, last_name));
    }

    @PatchMapping("/update-address/{id}")
    EntityModel<Employee> updateEmployeeAddress(@PathVariable("id") int id, @RequestBody List<Address> addresses) {
        return EntityModel.of(employeeService.updateEmployeeAddress(id, addresses));
    }

    @PatchMapping("/update-children/{id}")
    EntityModel<Employee> updateEmployeeChildren(@PathVariable("id") int id, @RequestBody List<Child> children) {
        return EntityModel.of(employeeService.updateEmployeeChildren(id, children));
    }

    @PatchMapping("/update-spouse/{id}")
    EntityModel<Employee> updateEmployeeSpouse(@PathVariable("id") int id, @RequestBody Spouse spouse) {
        return EntityModel.of(employeeService.updateEmployeeSpouse(id, spouse));
    }

    @DeleteMapping("/delete-Employee/{id}")
    void deleteEmployeeById(@PathVariable("id") int id) {
        employeeService.deleteEmployeeById(id);
    }


}
