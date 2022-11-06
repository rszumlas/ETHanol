package com.rszumlas.shelf;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/shelf")
@RestController
public class ShelfController {

    private final ShelfService shelfService;

    @GetMapping(path = "{vodka_id}")
    public Optional<Shelf> findByVodkaId(@PathVariable("vodka_id") Integer vodka_id) {
        return shelfService.findByVodkaId(vodka_id);
    }

//    @PatchMapping
//    public void updateCratesAmount(@RequestBody @Lazy OrderRequest orderRequest) {
//        shelfService.updateCratesAmount(orderRequest);
//    }

}
