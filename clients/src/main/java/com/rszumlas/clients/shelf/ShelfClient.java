package com.rszumlas.clients.shelf;

import com.rszumlas.clients.parcel.ParcelRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(
        name = "shelf",
        url = "${clients.shelf.url}"
)
public interface ShelfClient {

    @GetMapping(path = "api/v1/shelf/{shelf_id}")
    Optional<ShelfRequest> findShelfByVodkaId(@PathVariable("shelf_id") Long vodka_id);

    @PatchMapping
    void updateCratesAmount(@RequestBody ParcelRequest parcelRequest);

}
