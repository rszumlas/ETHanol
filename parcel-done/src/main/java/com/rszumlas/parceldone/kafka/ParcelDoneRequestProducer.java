package com.rszumlas.parceldone.kafka;

import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelDoneRequestProducer {

    public static final Logger LOGGER = LoggerFactory.getLogger(ParcelDoneRequestProducer.class);
    private final KafkaTemplate<String, ParcelDoneRequest> kafkaTemplate;

    public void sendMessage(ParcelDoneRequest event) {
        LOGGER.info(String.format("Event sent -> %s", event));
        kafkaTemplate.send("parcel_done_request_topic", event);
    }

}
