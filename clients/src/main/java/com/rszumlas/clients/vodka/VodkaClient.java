package com.rszumlas.clients.vodka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        contextId = "vodkaContextId",
        name = "vodka",
        url = "${clients.vodka.url}"
)
public interface VodkaClient {

    @GetMapping(path = "api/v1/vodka/{vodka_id}")
    VodkaRequest findVodkaById(@PathVariable("vodka_id") Long vodka_id);

}
