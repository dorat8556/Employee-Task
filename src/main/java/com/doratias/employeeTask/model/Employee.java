package com.doratias.employeeTask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.List;

/**
 * @author Dor Atias
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends RepresentationModel<Employee> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String first_name;

    private String last_name;

    @OneToOne
    private Spouse spouse;

    @OneToMany
    private List<Address> addresses;

    @OneToMany
    private List<Child> children;
}
