package com.rszumlas.parcel.kafka;

import com.rszumlas.parcel.Parcel;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelProducer {

    public static final Logger LOGGER = LoggerFactory.getLogger(ParcelProducer.class);
    private final KafkaTemplate<String, Parcel> kafkaTemplate;

    public void sendMessage(Parcel event) {
        LOGGER.info(String.format("Event sent -> %s", event));
        kafkaTemplate.send("parcel_topic", event);
    }

}
