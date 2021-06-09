package com.doratias.employeeTask.cotroller;

import com.doratias.employeeTask.model.Employee;
import com.doratias.employeeTask.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
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

    @GetMapping(value = "/{id}", produces = { "application/hal+json" })
    RepresentationModel<Employee> getEmployeeById(@PathVariable("id") int id){
        Link selfLink = linkTo(methodOn(EmployeeController.class)
                .getEmployeeById(id)).withSelfRel();

        Employee employee = employeeService.getEmployee(id);
        employee.add(selfLink);
        return (RepresentationModel<Employee>) CollectionModel.of(employee);
    }

    @GetMapping("/")
    EntityModel<List<Employee>> getEmployees(){
        return EntityModel.of(employeeService.getAllEmployees());
    }

    @PostMapping("/add-employee")
    EntityModel<Employee> createEmployee(@RequestBody Employee employee){
        return EntityModel.of(employeeService.createEmployee(employee));
    }

    @PutMapping("/replace-employee/{id}")
    EntityModel<Employee> replaceEmployee(@RequestBody Employee employee, @PathVariable("id") int id){
        return EntityModel.of(employeeService.replaceEmployee(id, employee));
    }

    @PatchMapping("/update-first-name/{id}")
    EntityModel<Employee> updateEmployeeFirstName(@PathVariable("id") int id, @RequestBody String first_name){
        return EntityModel.of(employeeService.updateEmployeeFirstName(id, first_name));
    }

    @PatchMapping("/update-last-name/{id}")
    EntityModel<Employee> updateEmployeeLastName(@PathVariable("id") int id, @RequestBody String last_name){
        return EntityModel.of(employeeService.updateEmployeeLastName(id, last_name));
    }

    //TODO  add update for : Address , children and Spouse

    @DeleteMapping("/delete-Employee/{id}")
    void deleteEmployeeById(@PathVariable("id") int id){
        employeeService.deleteEmployeeById(id);
    }


}
