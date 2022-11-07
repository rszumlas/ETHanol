package com.rszumlas.orderdone;

import com.rszumlas.employee.Employee;
import com.rszumlas.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "OrderDone")
@Table(name = "order_done")
public class OrderDone {

    @EmbeddedId
    private OrderDoneId id;

    @OneToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    private Order order;

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
