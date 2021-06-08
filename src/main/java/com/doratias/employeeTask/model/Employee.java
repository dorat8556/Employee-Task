package com.doratias.employeeTask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * @author Dor Atias
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    private String first_name;

    private String last_name;

    @OneToOne
    private Spouse spouse;

    @OneToMany
    private List<Address> addresses;

    @OneToMany
    private Set<Child> children;
}
