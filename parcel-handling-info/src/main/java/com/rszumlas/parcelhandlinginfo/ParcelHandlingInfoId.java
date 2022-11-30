package com.rszumlas.parcelhandlinginfo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class ParcelHandlingInfoId implements Serializable {

    @Column(name = "parcel_id")
    private Long parcel_id;

}
