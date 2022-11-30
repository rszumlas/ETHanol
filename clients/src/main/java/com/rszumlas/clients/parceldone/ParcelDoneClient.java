package com.rszumlas.clients.parceldone;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(
        contextId = "parcelDoneContextId",
        name = "parcelDone",
        url = "${clients.parcelDone.url}"
)
public interface ParcelDoneClient {

    @PostMapping(path = "api/v1/parcel-done")
    void insertParcelDone(@RequestBody ParcelDoneRequest parcelDoneRequest);

}
