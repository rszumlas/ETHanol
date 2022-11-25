package com.rszumlas.parceldone;

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
public class ParcelDoneId implements Serializable {

    @Column(name = "parcel_id")
    private Long parcel_id;

    @Column(name = "account_id")
    private Long account_id;

}
