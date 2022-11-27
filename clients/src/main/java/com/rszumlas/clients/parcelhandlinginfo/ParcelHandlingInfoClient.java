package com.rszumlas.clients.parcelhandlinginfo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        contextId = "parcelHandlingInfoContextId",
        name = "parcelHandlingInfo",
        url = "${clients.parcelHandlingInfo.url}"
)
public interface ParcelHandlingInfoClient {

    @PostMapping
    void insertParcelHandlingInfo(@RequestBody ParcelHandlingInfoRequest parcelHandlingInfoRequest);


}
