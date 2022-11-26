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

    @PutMapping
    public void insertParcelDone(@RequestBody ParcelDoneRequest parcelDoneRequest) {
        parcelDoneService.insertParcelDone(parcelDoneRequest);
    }

    @GetMapping(path = "{account_id}")
    Optional<ParcelDoneRequest> findParcelDoneByAccountId(@PathVariable("account_id") Long account_id) {
        return parcelDoneService.findParcelDoneByAccountId(account_id);
    }

}
