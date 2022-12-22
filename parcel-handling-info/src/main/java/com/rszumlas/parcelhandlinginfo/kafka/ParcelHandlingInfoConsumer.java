package com.rszumlas.parcelhandlinginfo.kafka;

import com.rszumlas.parcel.Parcel;
import com.rszumlas.parcelhandlinginfo.ParcelHandlingInfoService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelHandlingInfoConsumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(ParcelHandlingInfoConsumer.class);
    private final ParcelHandlingInfoService parcelHandlingInfoService;

    @KafkaListener(
            topics = "parcel_topic",
            groupId = "parcelHandlingInfoGroup"
    )
    public void consume(Parcel event) {
        LOGGER.info(String.format("Event received -> %s", event));
        parcelHandlingInfoService.insertParcelHandlingInfo(event);
    }

}
