package com.rszumlas.parcelhandlinginfo;

import com.rszumlas.clients.parcelhandlinginfo.ParcelHandlingInfoRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelHandlingInfoService {

    private final ParcelHandlingInfoRepository parcelHandlingInfoRepository;
    public void insertParcelHandlingInfo(ParcelHandlingInfoRequest parcelHandlingInfoRequest) {
        parcelHandlingInfoRepository.insertParcelHandlingInfo(parcelHandlingInfoRequest);
    }

}
