package com.rszumlas.parcelhandlinginfo;

import com.rszumlas.parcel.Parcel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelHandlingInfoService {

    private final ParcelHandlingInfoRepository parcelHandlingInfoRepository;

}
