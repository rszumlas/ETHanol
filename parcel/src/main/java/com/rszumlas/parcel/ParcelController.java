package com.rszumlas.parcel;

import com.rszumlas.clients.parcel.ParcelRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RequestMapping("api/v1/parcel")
@RestController
public class ParcelController {

    private final ParcelService parcelService;

    @GetMapping(path = "{parcel_id}")
    public Optional<ParcelRequest> findParcelById(@PathVariable("parcel_id") Long parcel_id) {
        return parcelService.findParcelById(parcel_id);
    }

    @PostMapping
    public void insertParcel(@RequestBody ParcelRequest parcelRequest) {
        parcelService.insertParcel(parcelRequest);
    }

}
