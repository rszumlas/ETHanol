package com.rszumlas.parceldone;

import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/parcel-done")
@RestController
public class ParcelDoneController {

    private final ParcelDoneService parcelDoneService;

    @PostMapping
    public void insertParcelDone(@RequestBody ParcelDoneRequest parcelDoneRequest) {
        parcelDoneService.insertParcelDone(parcelDoneRequest);
    }

}
