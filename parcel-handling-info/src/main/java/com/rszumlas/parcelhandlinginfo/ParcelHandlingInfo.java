package com.rszumlas.parcelhandlinginfo;

import com.rszumlas.parcel.Parcel;
import com.rszumlas.shelf.Shelf;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ParcelHandlingInfo")
@Table(name = "parcel_handling_info")
public class ParcelHandlingInfo {

    @EmbeddedId
    private ParcelHandlingInfoId id;

    @OneToOne
    @MapsId("parcel_id")
    @JoinColumn(name = "parcel_id")
    private Parcel parcel;

    @ManyToOne
    @JoinColumn(
            name = "shelf_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "phi_shelf_id_fk"
            )
    )
    private Shelf shelf;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime created_at;

}
