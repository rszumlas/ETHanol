package com.rszumlas.parcel;

import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.parcelhandlinginfo.ParcelHandlingInfoRequest;
import com.rszumlas.clients.shelf.ShelfClient;
import com.rszumlas.vodka.Vodka;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelService {

    private final ParcelRepository parcelRepository;
    private final KafkaTemplate<String, Parcel> kafkaTemplate;
    public static final Logger LOGGER = LoggerFactory.getLogger(ParcelService.class);

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

        LOGGER.info(String.format("Message sent -> %s", parcel));
        kafkaTemplate.send("parcel_topic", parcel);
    }

}
