package com.rszumlas.clients.parcel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        contextId = "parcelClient",
        name = "parcel",
        url = "${clients.parcel.url}"
)
public interface ParcelClient {

    @GetMapping(path = "api/v1/parcel/{parcel_id}")
    ParcelRequest findParcelById(@PathVariable("parcel_id") Long parcel_id);

    @PutMapping
    void insertParcel(@RequestBody ParcelRequest parcelRequest);

}
