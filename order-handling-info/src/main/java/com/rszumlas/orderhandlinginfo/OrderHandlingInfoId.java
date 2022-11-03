package com.rszumlas.orderhandlinginfo;

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
public class OrderHandlingInfoId implements Serializable {

    @Column(name = "order_id")
    private Integer order_id;

    @Column(name = "shelf_id")
    private Integer shelf_id;

}
