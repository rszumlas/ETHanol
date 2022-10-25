package com.rszumlas.ethanol;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class OrderAcceptedId implements Serializable {

    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "employee_id")
    private Long employee_id;

}
