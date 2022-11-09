package com.rszumlas.employee;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Employee")
@Table(name = "employee")
public class Employee {

    @Id
    @SequenceGenerator(
            name = "order_type_sequence",
            sequenceName = "order_type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "order_type_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String first_name;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String last_name;

    @Column(
            name = "eth",
            nullable = false
    )
    private double eth;

    @Column(
            name = "PESEL",
            nullable = false
    )
    private int PESEL;

}
