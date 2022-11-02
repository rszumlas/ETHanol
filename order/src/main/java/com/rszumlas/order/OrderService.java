package com.rszumlas.order;

import com.rszumlas.clients.order.OrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void insertOrder(OrderRequest orderRequest) {

        Order order = Order.builder()
                .orderType(orderRequest.orderType())
                .vodka(orderRequest.vodka())
                .crates(orderRequest.crates())
                .build();
        orderRepository.save(order);

    }

}
