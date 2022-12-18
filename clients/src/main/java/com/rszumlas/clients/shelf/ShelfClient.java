package com.rszumlas.clients.shelf;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        contextId = "shelfContextId",
        name = "shelf",
        url = "${clients.shelf.url}"
)
public interface ShelfClient {

    @GetMapping(path = "api/v1/shelf/vodka-id/{vodka_id}")
    Long findShelfIdByVodkaId(@PathVariable("vodka_id") Long vodka_id);

    @GetMapping(path = "api/v1/shelf/shelf-id/{shelf_id}")
    ShelfRequest findShelfById(@PathVariable("shelf_id") Long shelf_id);

}
