package com.rszumlas.clients.vodka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "vodka",
        url = "${clients.vodka.url}"
)
public interface VodkaClient {

    @GetMapping(path = "{id}")
    VodkaRequest findById(@PathVariable("id") Long vodka_id);

}
