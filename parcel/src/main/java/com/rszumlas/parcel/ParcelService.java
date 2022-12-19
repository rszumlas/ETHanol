package com.rszumlas.parcel;

import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.parcelhandlinginfo.ParcelHandlingInfoRequest;
import com.rszumlas.clients.shelf.ShelfClient;
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
    private final ShelfClient shelfClient;
    private final KafkaTemplate<String, ParcelHandlingInfoRequest> kafkaTemplate;
    public static final Logger LOGGER = LoggerFactory.getLogger(ParcelService.class);


    //  findParcelById
    public Parcel findParcelById(Long parcel_id) {
        return parcelRepository.findParcelById(parcel_id);
    }

    //  insertParcel
    public void insertParcel(ParcelRequest parcelRequest) {
        ModelMapper modelMapper = new ModelMapper();
        Parcel parcel = modelMapper.map(parcelRequest, Parcel.class);
        parcelRepository.saveAndFlush(parcel);
        sendParcelHandlingInfoMessage(parcel);
    }

    private void sendParcelHandlingInfoMessage(Parcel parcel) {
        ParcelHandlingInfoRequest parcelHandlingInfoRequest = new ParcelHandlingInfoRequest(
                parcel.getId(),
                shelfClient.findShelfIdByVodkaId(parcel.getVodka().getId()),
                parcel.getCrates(),
                parcel.getCreated_at()
        );
        LOGGER.info(String.format("Message sent -> %s", parcelHandlingInfoRequest));
        kafkaTemplate.send("parcelHandlingInfo", parcelHandlingInfoRequest);
    }

}
