package com.rszumlas.clients.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "order",
        url = "${clients.order.url}"
)
public interface OrderClient {

    @PutMapping
    void insertOrder(@RequestBody OrderRequest orderRequest);

}
