package com.rszumlas.shelf;

import com.rszumlas.clients.shelf.ShelfRequest;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/shelf")
@RestController
public class ShelfController {

    private final ShelfService shelfService;

    @GetMapping(path = "shelf-id/{shelf_id}")
    public ShelfRequest findShelfById(@PathVariable("shelf_id") Long shelf_id) {
        Shelf shelf = shelfService.findShelfById(shelf_id);
        return new ShelfRequest(
                shelf.getCrates(),
                shelf.getMax_crates(),
                shelf.getVodka().getId()
        );
    }

}
