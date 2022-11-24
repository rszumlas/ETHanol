package com.rszumlas.vodka;

import com.rszumlas.clients.vodka.VodkaRequest;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/vodka")
@RestController
public class VodkaController {

    private final VodkaService vodkaService;

    @GetMapping(path = "{vodka_id}")
    public VodkaRequest findVodkaById(@PathVariable("vodka_id") Long vodka_id) {
        return  vodkaService.findVodkaById(vodka_id);
    }
}
