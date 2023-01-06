package com.rszumlas.vodka;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Vodka")
@Table(name = "vodka")
public class Vodka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false,
            columnDefinition = "SERIAL"
    )
    private Long id;

    @Column(
            name = "name",
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "flavour",
            columnDefinition = "TEXT"
    )
    private String flavour;

    @Column(
            name = "bottle_size"
    )
    private Integer bottle_size;

    @Column(
            name = "voltage",
            columnDefinition = "NUMERIC(3,1)"
    )
    private Double voltage;

    public Vodka(long l) {

    }
}
