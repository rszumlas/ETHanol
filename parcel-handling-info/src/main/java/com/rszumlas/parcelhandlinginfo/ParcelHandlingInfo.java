package com.rszumlas.parcelhandlinginfo;

import com.rszumlas.parcel.Parcel;
import com.rszumlas.shelf.Shelf;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
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

    @OneToOne
    @MapsId("shelf_id")
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime created_at;

}
