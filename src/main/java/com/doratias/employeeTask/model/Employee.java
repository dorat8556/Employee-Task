package com.doratias.employeeTask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.List;

/**
 * @author Dor Atias
 */
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
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
