package com.rszumlas.parcelaccepted;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class ParcelAcceptedId implements Serializable {

    @Column(name = "parcel_id")
    private Long parcel_id;

}
