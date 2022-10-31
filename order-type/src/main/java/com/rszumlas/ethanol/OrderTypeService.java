package com.rszumlas.ethanol;

import org.springframework.stereotype.Service;

@Service
public class OrderTypeService {

    private final OrderTypeRepository orderTypeRepository;

    public OrderTypeService(OrderTypeRepository orderTypeRepository) {
        this.orderTypeRepository = orderTypeRepository;
    }

}
