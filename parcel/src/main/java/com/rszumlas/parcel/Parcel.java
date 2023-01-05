package com.rszumlas.parcel;

import com.rszumlas.vodka.Vodka;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Parcel")
@Table(name = "parcel")
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false,
            columnDefinition = "SERIAL"
    )
    private Long id;

    @Column(
            name = "parcel_type",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String delivery_type;

    @ManyToOne
    @JoinColumn(
            name = "vodka_id",
            referencedColumnName = "id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "parcel_vodka_id_fk"
            )
    )
    private Vodka vodka;

    @Column(
            name = "crates",
            nullable = false
    )
    private Integer crates;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime created_at;

}
