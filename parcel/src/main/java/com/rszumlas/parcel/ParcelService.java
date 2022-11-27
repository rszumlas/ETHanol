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

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParcelService {

    private final ParcelRepository parcelRepository;
    private final ParcelHandlingInfoClient parcelHandlingInfoClient;
    private final VodkaClient vodkaClient;
    private final ShelfClient shelfClient;


    public Optional<ParcelRequest> findParcelById(Long parcel_id) {
        return parcelRepository.findParcelById(parcel_id);
    }

    public void insertParcel(ParcelRequest parcelRequest) {
        Parcel parcel = castRequestToParcel(parcelRequest);
        parcelRepository.save(parcel);
        insertParcelHandlingInfo(parcelRequest, parcel);
    }

    private Parcel castRequestToParcel(ParcelRequest parcelRequest) {

        VodkaRequest vodkaRequest = vodkaClient.findVodkaById(parcelRequest.vodka_id());

        return Parcel.builder()
                .delivery_type("import")
                .vodka(Vodka.builder()
                        .id(parcelRequest.vodka_id())
                        .name(vodkaRequest.name())
                        .bottle_size(vodkaRequest.bottle_size())
                        .voltage(vodkaRequest.voltage())
                        .build())
                .crates(parcelRequest.crates())
                .build();
    }

    private void insertParcelHandlingInfo(ParcelRequest parcelRequest, Parcel parcel) {
        ParcelHandlingInfoRequest parcelHandlingInfoRequest = new ParcelHandlingInfoRequest(
                parcel.getId(),
                shelfClient.findShelfIdByVodkaId(parcelRequest.vodka_id()),
                LocalDateTime.now()
        );
        parcelHandlingInfoClient.insertParcelHandlingInfo(parcelHandlingInfoRequest);
    }

}
