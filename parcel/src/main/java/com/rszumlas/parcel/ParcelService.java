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

    public void insertParcel(ParcelRequest parcelRequest) {
        Parcel parcel = new Parcel(
                null,
                parcelRequest.delivery_type(),
                new Vodka(parcelRequest.vodka_id()),
                parcelRequest.crates(),
                parcelRequest.created_at()
        );
        parcelRepository.saveAndFlush(parcel);
        parcelProducer.sendMessage(parcel);
    }

    public Parcel findParcelById(Long parcel_id) {
        return parcelRepository.findById(parcel_id).orElseThrow();
    }

}
