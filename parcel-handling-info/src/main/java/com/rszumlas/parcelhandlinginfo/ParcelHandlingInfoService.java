package com.rszumlas.parcelhandlinginfo;

import com.rszumlas.clients.parcelhandlinginfo.ParcelHandlingInfoRequest;
import com.rszumlas.parcel.Parcel;
import com.rszumlas.shelf.Shelf;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParcelHandlingInfoService {

    private final ParcelHandlingInfoRepository parcelHandlingInfoRepository;
    private ParcelHandlingInfoRequest parcelHandlingInfoRequest = ParcelHandlingInfoRequest.builder().build();

    // getShelfId
    private Long getShelfId(Shelf shelf) {
        return shelf.getId();
    }

    // insertParcelHandlingInfo
    public void provideParcelEvent(Parcel event) {
        parcelHandlingInfoRequest.setParcel_id(event.getId());
        parcelHandlingInfoRequest.setCrates(event.getCrates());
        parcelHandlingInfoRequest.setCreated_at(event.getCreated_at());
    }

    public void provideShelfEventAndInsertPHI(Shelf event) {
        parcelHandlingInfoRequest.setShelf_id(event.getId());
        insertParcelHandlingInfo(parcelHandlingInfoRequest);
    }

    private void insertParcelHandlingInfo(ParcelHandlingInfoRequest phiRequest) {
        if (ObjectUtils.allNotNull(phiRequest)) {
            parcelHandlingInfoRepository.insertParcelHandlingInfo(phiRequest);
            resetParcelHandlingInfoRequest(phiRequest);
        }
    }

    private void resetParcelHandlingInfoRequest(ParcelHandlingInfoRequest phiRequest) {
        phiRequest.setParcel_id(null);
        phiRequest.setShelf_id(null);
        phiRequest.setCrates(null);
        phiRequest.setCreated_at(null);
    }

}
