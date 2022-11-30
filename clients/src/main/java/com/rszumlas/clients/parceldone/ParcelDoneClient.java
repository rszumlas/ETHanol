package com.rszumlas.clients.parceldone;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        contextId = "parcelDoneContextId",
        name = "parcelDone",
        url = "${clients.parcelDone.url}"
)
public interface ParcelDoneClient {

}
