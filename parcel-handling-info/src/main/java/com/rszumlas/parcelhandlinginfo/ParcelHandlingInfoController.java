package com.rszumlas.parcelhandlinginfo;

import com.rszumlas.clients.parcelhandlinginfo.ParcelHandlingInfoRequest;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/parcel-handling-info")
@RestController
public class ParcelHandlingInfoController {

    private ParcelHandlingInfoService parcelHandlingInfoService;

    @PostMapping
    void insertParcelHandlingInfo(@RequestBody ParcelHandlingInfoRequest parcelHandlingInfoRequest) {
        parcelHandlingInfoService.insertParcelHandlingInfo(parcelHandlingInfoRequest);
    }

}
