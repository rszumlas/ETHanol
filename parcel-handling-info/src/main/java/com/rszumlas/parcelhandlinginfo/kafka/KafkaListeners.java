package com.rszumlas.parcelhandlinginfo.kafka;

import com.rszumlas.clients.parcelhandlinginfo.ParcelHandlingInfoRequest;
import com.rszumlas.parcelhandlinginfo.ParcelHandlingInfoService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaListeners {

    private final ParcelHandlingInfoService parcelHandlingInfoService;
    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(
            topics = "parcelHandlingInfo",
            groupId = "parcelHandlingInfoGroup"
    )
    void listener(ParcelHandlingInfoRequest data) {
        LOGGER.info(String.format("Message received -> %s", data));
        parcelHandlingInfoService.insertParcelHandlingInfo(data);
    }

}
