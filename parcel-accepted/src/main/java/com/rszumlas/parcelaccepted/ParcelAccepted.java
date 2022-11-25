package com.rszumlas.parcelaccepted;

import com.rszumlas.account.Account;
import com.rszumlas.parcel.Parcel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ParcelAccepted")
@Table(name = "parcel_accepted")
public class ParcelAccepted {

    @EmbeddedId
    private ParcelAcceptedId id;

    @OneToOne
    @MapsId("parcel_id")
    @JoinColumn(name = "parcel_id")
    private Parcel parcel;

    @ManyToOne
    @MapsId("account_id")
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime created_at;

}
