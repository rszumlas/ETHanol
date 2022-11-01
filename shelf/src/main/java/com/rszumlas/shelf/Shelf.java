package com.rszumlas.shelf;

import com.rszumlas.vodka.Vodka;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Shelf")
@Table(name = "shelf")
public class Shelf {

    @Id
    @SequenceGenerator(
            name = "shelf_sequence",
            sequenceName = "shelf_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "shelf_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "crates",
            nullable = false
    )
    private Integer crates;

    @Column(
            name = "crates",
            nullable = false
    )
    private Integer max_crates;

    @OneToOne(
            cascade = CascadeType.PERSIST,
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
