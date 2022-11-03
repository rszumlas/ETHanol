package com.rszumlas.profession;

import com.rszumlas.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Profession")
@Table(name = "profession")
public class Profession {

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
    private Integer id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @OneToMany(
            mappedBy = "profession",
            fetch = FetchType.EAGER
    )
    private List<Employee> employees = new ArrayList<>();

}
