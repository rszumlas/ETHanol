package com.rszumlas.parcelhandlinginfo;

import com.rszumlas.clients.parcelhandlinginfo.ParcelHandlingInfoRequest;
import com.rszumlas.clients.shelf.ShelfClient;
import com.rszumlas.parcel.Parcel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelHandlingInfoService {

    private final ParcelHandlingInfoRepository parcelHandlingInfoRepository;
    private final ShelfClient shelfClient;

    public void insertParcelHandlingInfo(Parcel parcel) {

        ParcelHandlingInfoRequest parcelHandlingInfoRequest = new ParcelHandlingInfoRequest(
                parcel.getId(),
                shelfClient.findShelfIdByVodkaId(parcel.getVodka().getId()),
                parcel.getCrates(),
                parcel.getCreated_at()
        );

        parcelHandlingInfoRepository.insertParcelHandlingInfo(parcelHandlingInfoRequest);
    }

}
