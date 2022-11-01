package com.rszumlas.shelf;

import com.rszumlas.clients.order.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/shelf")
@RestController
public class ShelfController {

    private final ShelfService shelfService;

    @PatchMapping
    public void updateCratesAmount(@RequestBody OrderRequest orderRequest) {
        shelfService.updateCratesAmount(orderRequest);
    }

}
