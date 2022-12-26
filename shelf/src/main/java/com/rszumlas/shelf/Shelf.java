package com.rszumlas.shelf;

import com.rszumlas.vodka.Vodka;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Shelf")
@Table(name = "shelf")
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            name = "id",
            updatable = false,
            columnDefinition = "SERIAL"
    )
    private Long id;

    @Column(
            name = "crates",
            nullable = false
    )
    private Integer crates;

    @Column(
            name = "max_crates",
            nullable = false
    )
    private Integer max_crates;

    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "vodka_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "shelf_vodka_id_fk"
            )
    )
    private Vodka vodka;
}
