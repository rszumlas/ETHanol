package com.rszumlas.parcel;

import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.vodka.VodkaClient;
import com.rszumlas.clients.vodka.VodkaRequest;
import com.rszumlas.vodka.Vodka;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelService {

    private final VodkaClient vodkaClient;
    private final ParcelRepository parcelRepository;


    public ParcelRequest findParcelById(Long parcel_id) {
        return parcelRepository.findParcelById(parcel_id);
    }

    public void insertParcel(ParcelRequest parcelRequest) {
        Parcel parcel = castRequestToParcel(parcelRequest);
        parcelRepository.save(parcel);
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

}
