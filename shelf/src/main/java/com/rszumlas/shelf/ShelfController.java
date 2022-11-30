package com.rszumlas.shelf;

import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.shelf.ShelfRequest;
import com.rszumlas.vodka.Vodka;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/shelf")
@RestController
public class ShelfController {

    private final ShelfService shelfService;

    @GetMapping(path = "vodka-id/{vodka_id}")
    public Long findShelIdfByVodkaId(@PathVariable("vodka_id") Long vodka_id) {
        return shelfService.findShelIdfByVodkaId(vodka_id);
    }

    @GetMapping(path = "shelf-id/{shelf_id}")
    public ShelfRequest findShelfById(@PathVariable("shelf_id") Long shelf_id) {
        Shelf shelf = shelfService.findShelfById(shelf_id);
        return new ShelfRequest(
                shelf.getCrates(),
                shelf.getMax_crates(),
                shelf.getVodka().getId()
        );
    }

    @PutMapping(path = "{parcel_id}")
    public void updateCratesAmount(@PathVariable Long parcel_id) {
        shelfService.updateCratesAmount(parcel_id);
    }

}
