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

    @PostMapping
    public void insertParcel(@RequestBody ParcelRequest parcelRequest) {
        parcelService.insertParcel(parcelRequest);
    }

    @GetMapping(path = "{parcel_id}")
    public ParcelRequest findParcelById(@PathVariable("parcel_id") Long parcel_id) {
        Parcel parcel = parcelService.findParcelById(parcel_id);
        return new ParcelRequest(
                parcel.getDelivery_type(),
                parcel.getCrates(),
                parcel.getVodka().getId(),
                parcel.getCreated_at()
        );
    }

}
