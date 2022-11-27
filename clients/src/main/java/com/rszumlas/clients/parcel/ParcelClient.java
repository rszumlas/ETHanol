package com.rszumlas.clients.parcel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(
        contextId = "parcelContextId",
        name = "parcel",
        url = "${clients.parcel.url}"
)
public interface ParcelClient {

    @GetMapping(path = "api/v1/parcel/{parcel_id}")
    Optional<ParcelRequest> findParcelById(@PathVariable("parcel_id") Long parcel_id);

    @PostMapping
    void insertParcel(@RequestBody ParcelRequest parcelRequest);

}
