package com.rszumlas.parceldone;

import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import com.rszumlas.parceldone.kafka.ParcelDoneProducer;
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
    private final ParcelDoneProducer parcelDoneProducer;

    public Boolean checkIfFinished(Long parcel_id) {
        return parcelDoneRepository.checkIfFinished(parcel_id);
    }

    public void insertParcelDone(ParcelDoneRequest parcelDoneRequest) {
        parcelDoneRepository.insertParcelDone(parcelDoneRequest);
        parcelDoneProducer.sendMessage(parcelDoneRequest);
    }

}