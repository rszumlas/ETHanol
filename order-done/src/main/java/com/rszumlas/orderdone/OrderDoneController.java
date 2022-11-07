package com.rszumlas.orderdone;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/order-done")
@RestController
public class OrderDoneController {

    private final OrderDoneService orderDoneService;

}
