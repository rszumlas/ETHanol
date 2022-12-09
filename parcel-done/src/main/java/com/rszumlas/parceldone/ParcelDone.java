package com.rszumlas.parceldone;

import com.rszumlas.account.Account;
import com.rszumlas.parcel.Parcel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "ParcelDone")
@Table(name = "parcel_done")
public class ParcelDone {

    @EmbeddedId
    private ParcelDoneId id;

    @OneToOne
    @MapsId("parcel_id")
    @JoinColumn(name = "parcel_id")
    private Parcel parcel;

    @ManyToOne
    @MapsId("account_id")
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(
            name = "delivery_time_seconds",
            nullable = false
    )
    private Integer delivery_time_seconds;

    @Column(
            name = "eth_earned",
            nullable = false
    )
    private Double eth_earned;

    @Column(
            name = "is_finished",
            nullable = false
    )
    private Boolean is_finished;

}
