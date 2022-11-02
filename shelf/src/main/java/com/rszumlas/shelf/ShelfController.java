package com.rszumlas.shelf;

import com.rszumlas.clients.order.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/shelf")
@RestController
public class ShelfController {

    private final ShelfService shelfService;

    @GetMapping(path = "{vodka_id}")
    public Optional<Shelf> findByVodkaId(@PathVariable("vodka_id") Long vodka_id) {
        return shelfService.findByVodkaId(vodka_id);
    }

    @PatchMapping
    public void updateCratesAmount(@RequestBody OrderRequest orderRequest) {
        shelfService.updateCratesAmount(orderRequest);
    }

}
