package com.rszumlas.order;

import com.rszumlas.clients.order.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/order")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PutMapping
    public void insertOrder(@RequestBody OrderRequest orderRequest) {
        orderService.insertOrder(orderRequest);
    }

}
