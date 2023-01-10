package com.rszumlas.parceldone;

import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/parcel-done")
@RestController
public class ParcelDoneController {

    private final ParcelDoneService parcelDoneService;

    @PostMapping
    public void saveParcelDone(@RequestBody ParcelDoneRequest parcelDoneRequest) {
        parcelDoneService.saveParcelDone(parcelDoneRequest);
    }

    @GetMapping(path = "/{parcel_id}")
    public Boolean checkIfFinished(@PathVariable("parcel_id") Long parcel_id) {
        return parcelDoneService.checkIfFinished(parcel_id);
    }

}
