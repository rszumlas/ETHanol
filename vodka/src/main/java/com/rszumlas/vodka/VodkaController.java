package com.rszumlas.vodka;

import com.rszumlas.clients.vodka.VodkaRequest;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/vodka")
@RestController
public class VodkaController {

    private final VodkaService vodkaService;

    @GetMapping(path = "{vodka_id}")
    public VodkaRequest findVodkaById(@PathVariable("vodka_id") Long vodka_id) {
        Vodka vodka = vodkaService.findVodkaById(vodka_id);
        return new VodkaRequest(
                vodka.getName(),
                vodka.getFlavour(),
                vodka.getBottle_size(),
                vodka.getVoltage());
    }
}
