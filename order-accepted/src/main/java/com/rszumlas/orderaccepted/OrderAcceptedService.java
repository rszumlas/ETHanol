package com.rszumlas.orderaccepted;

import org.springframework.stereotype.Service;

@Service
public class OrderAcceptedService {

    private final OrderAcceptedRepository orderAcceptedRepository;

    public OrderAcceptedService(OrderAcceptedRepository orderAcceptedRepository) {
        this.orderAcceptedRepository = orderAcceptedRepository;
    }

}