package com.rszumlas.parceldone;

import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelDoneService {

    private final ParcelDoneRepository parcelDoneRepository;
    private final KafkaTemplate<String, ParcelDoneRequest> kafkaTemplate;
    public static final Logger LOGGER = LoggerFactory.getLogger(ParcelDoneService.class);

    public Boolean checkIfFinished(Long parcel_id) {
        return parcelDoneRepository.checkIfFinished(parcel_id);
    }

    public void insertParcelDone(ParcelDoneRequest parcelDoneRequest) {
        parcelDoneRepository.insertParcelDone(parcelDoneRequest);
        LOGGER.info(String.format("Message sent -> %s", parcelDoneRequest));
        kafkaTemplate.send("parcel_done_request_topic", parcelDoneRequest);
    }

}