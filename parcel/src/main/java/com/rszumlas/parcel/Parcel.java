package com.rszumlas.parcel;

import com.rszumlas.vodka.Vodka;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Parcel")
@Table(name = "parcel")
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false
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

}