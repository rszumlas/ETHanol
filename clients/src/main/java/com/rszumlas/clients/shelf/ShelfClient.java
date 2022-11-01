package com.rszumlas.clients.shelf;

import com.rszumlas.clients.order.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "shelf",
        url = "${clients.shelf.url}"
)
public interface ShelfClient {

    @PatchMapping
    void updateCratesAmount(@RequestBody OrderRequest orderRequest);

}
