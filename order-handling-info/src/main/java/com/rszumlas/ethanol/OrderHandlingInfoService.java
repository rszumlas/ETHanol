package com.rszumlas.ethanol;

import org.springframework.stereotype.Service;

@Service
public class OrderHandlingInfoService {

    private final OrderHandlingInfoRepository orderHandlingInfoRepository;

    public OrderHandlingInfoService(OrderHandlingInfoRepository orderHandlingInfoRepository) {
        this.orderHandlingInfoRepository = orderHandlingInfoRepository;
    }

}
