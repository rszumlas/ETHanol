package com.rszumlas.parcel;

import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.parcel.kafka.ParcelProducer;
import com.rszumlas.vodka.Vodka;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelService {

    private final ParcelRepository parcelRepository;
    private final ParcelProducer parcelProducer;

    public Parcel findParcelById(Long parcel_id) {
        return parcelRepository.findParcelById(parcel_id);
    }

    public void insertParcel(ParcelRequest parcelRequest) {

        Parcel parcel = Parcel.builder()
                .delivery_type(parcelRequest.delivery_type())
                .vodka(Vodka.builder()
                        .id(parcelRequest.vodka_id())
                        .build())
                .crates(parcelRequest.crates())
                .created_at(parcelRequest.created_at())
                .build();
        parcelRepository.saveAndFlush(parcel);
        parcelProducer.sendMessage(parcel);
    }

}
