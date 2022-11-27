package com.rszumlas.parcelhandlinginfo;

import com.rszumlas.clients.parcelhandlinginfo.ParcelHandlingInfoRequest;
import com.rszumlas.parcel.Parcel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class ParcelHandlingInfoService {

    private final ParcelHandlingInfoRepository parcelHandlingInfoRepository;

    void insertParcelHandlingInfo(ParcelHandlingInfoRequest parcelHandlingInfoRequest) {
        ModelMapper modelMapper = new ModelMapper();
        ParcelHandlingInfo parcelHandlingInfo = modelMapper.map(parcelHandlingInfoRequest, ParcelHandlingInfo.class);
        parcelHandlingInfoRepository.save(parcelHandlingInfo);
    }

}
