package com.rszumlas.parceldone;

import com.rszumlas.employee.Employee;
import com.rszumlas.parcel.Parcel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

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
    @MapsId("employee_id")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(
            name = "delivery_time",
            nullable = false,
            columnDefinition = "INTERVAL"
    )
    private Time delivery_time;

    @Column(
            name = "eth_earned",
            nullable = false
    )
    private Double eth_earned;

}
