package com.doratias.employeeTask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Dor Atias
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Spouse {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
}
