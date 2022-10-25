package com.rszumlas.ethanol;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "OrderHandlingInfo")
@Table(name = "order_handling_info")
public class OrderHandlingInfo {

    @EmbeddedId
    private OrderHandlingInfoId id;

    @OneToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne
    @MapsId("shelf_id")
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

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
