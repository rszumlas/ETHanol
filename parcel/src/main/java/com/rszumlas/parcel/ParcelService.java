package com.rszumlas.parcel;

import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.parcelhandlinginfo.ParcelHandlingInfoClient;
import com.rszumlas.clients.parcelhandlinginfo.ParcelHandlingInfoRequest;
import com.rszumlas.clients.shelf.ShelfClient;
import com.rszumlas.clients.vodka.VodkaClient;
import com.rszumlas.clients.vodka.VodkaRequest;
import com.rszumlas.vodka.Vodka;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelService {

    private final ParcelRepository parcelRepository;
    private final ParcelHandlingInfoClient parcelHandlingInfoClient;
    private final VodkaClient vodkaClient;
    private final ShelfClient shelfClient;

    //  findParcelById
    public Parcel findParcelById(Long parcel_id) {
        return parcelRepository.findParcelById(parcel_id);
    }

    //  insertParcel
    public void insertParcel(ParcelRequest parcelRequest) {
        Parcel parcel = castRequestToParcelEntity(parcelRequest);
        parcelRepository.saveAndFlush(parcel);
        insertParcelHandlingInfo(parcel);
    }

    private Parcel castRequestToParcelEntity(ParcelRequest parcelRequest) {
        VodkaRequest vodkaRequest = vodkaClient.findVodkaById(parcelRequest.vodka_id());
        return Parcel.builder()
                .delivery_type(parcelRequest.delivery_type())
                .vodka(Vodka.builder()
                        .id(parcelRequest.vodka_id())
                        .name(vodkaRequest.name())
                        .bottle_size(vodkaRequest.bottle_size())
                        .voltage(vodkaRequest.voltage())
                        .build())
                .crates(parcelRequest.crates())
                .created_at(parcelRequest.created_at())
                .build();
    }

    private void insertParcelHandlingInfo(Parcel parcel) {
        ParcelHandlingInfoRequest parcelHandlingInfoRequest = new ParcelHandlingInfoRequest(
                parcel.getId(),
                shelfClient.findShelfIdByVodkaId(parcel.getVodka().getId()),
                parcel.getCreated_at()
        );
        parcelHandlingInfoClient.insertParcelHandlingInfo(parcelHandlingInfoRequest);
    }

}
