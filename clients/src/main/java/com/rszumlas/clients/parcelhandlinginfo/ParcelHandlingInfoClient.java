package com.rszumlas.clients.parcelhandlinginfo;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        contextId = "parcelHandlingInfoContextId",
        name = "parcelHandlingInfo",
        url = "${clients.parcelHandlingInfo.url}"
)
public interface ParcelHandlingInfoClient {

}
