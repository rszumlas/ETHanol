package com.rszumlas.parcelhandlinginfo;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Setter
@AllArgsConstructor
@RequestMapping("api/v1/parcel-handling-info")
@RestController
public class ParcelHandlingInfoController {

    private ParcelHandlingInfoService parcelHandlingInfoService;

}
