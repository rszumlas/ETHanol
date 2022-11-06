package com.rszumlas.vodka;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Vodka")
@Table(name = "vodka")
public class Vodka {

    @Id
    @SequenceGenerator(
            name = "vodka_sequence",
            sequenceName = "vodka_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "vodka_sequence"
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

    @Column(
            name = "bottle_size",
            nullable = false
    )
    private int bottle_size;

    @Column(
            name = "voltage",
            nullable = false
    )
    private int voltage;

}
