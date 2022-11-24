package com.rszumlas.vodka;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Vodka")
@Table(name = "vodka")
public class Vodka {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

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
