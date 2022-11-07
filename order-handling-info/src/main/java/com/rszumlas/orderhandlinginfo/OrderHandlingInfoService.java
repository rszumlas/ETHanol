package com.rszumlas.orderhandlinginfo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderHandlingInfoService {

    private final OrderHandlingInfoRepository orderHandlingInfoRepository;


}
