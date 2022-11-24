package com.rszumlas.shelf;

import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.shelf.ShelfRequest;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
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
    public Optional<ShelfRequest> findShelfByVodkaId(@PathVariable("vodka_id") Long vodka_id) {
        return shelfService.findShelfByVodkaId(vodka_id);
    }

    @PatchMapping
    public void updateCratesAmount(@RequestBody ParcelRequest parcelRequest) {
        shelfService.updateCratesAmount(parcelRequest);
    }

}
