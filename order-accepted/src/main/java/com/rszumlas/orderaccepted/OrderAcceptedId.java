package com.rszumlas.orderaccepted;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class OrderAcceptedId implements Serializable {

    @Column(name = "order_id")
    private Integer order_id;

    @Column(name = "employee_id")
    private Integer employee_id;

}
