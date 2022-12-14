package com.rszumlas.clients.parceldone;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "parcel-done",
        url = "${clients.parcel-done.url}"
)
public interface ParcelDoneClient {

    @PostMapping(path = "api/v1/parcel-done")
    void insertParcelDone(@RequestBody ParcelDoneRequest parcelDoneRequest);

    @GetMapping(path = "api/v1/parcel-done/{parcel_id}")
    Boolean checkIfFinished(@PathVariable("parcel_id") Long parcel_id);

}
