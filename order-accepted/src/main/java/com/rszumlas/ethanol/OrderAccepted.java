package com.rszumlas.ethanol;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "OrderAccepted")
@Table(name = "order_accepted")
public class OrderAccepted {

    @EmbeddedId
    private OrderAcceptedId id;

    @OneToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("employee_id")
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(
            name = "eth",
            nullable = false
    )
    private Double eth;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIMEZONE"
    )
    private LocalDateTime created_at;

}
