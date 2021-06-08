package com.doratias.employeeTask.cotroller;

import com.doratias.employeeTask.model.Employee;
import com.doratias.employeeTask.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dor Atias
 */

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/get-employee-by-id")
    EntityModel<Employee> getEmployeeById(@RequestParam int id){
        return EntityModel.of(employeeService.getEmployee(id));
    }

    @PostMapping("/add-employee")
    EntityModel<Employee> createEmployee(@RequestBody Employee employee){
        return EntityModel.of(employeeService.createEmployee(employee));
    }

}
