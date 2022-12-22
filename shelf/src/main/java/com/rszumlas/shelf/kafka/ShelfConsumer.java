package com.rszumlas.shelf.kafka;

import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import com.rszumlas.shelf.ShelfService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShelfConsumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(ShelfConsumer.class);
    private final ShelfService shelfService;

    @KafkaListener(
            topics = "parcel_done_request_topic",
            groupId = "shelfGroup"
    )
    public void consume(ParcelDoneRequest event) {
        LOGGER.info(String.format("Event received -> %s", event));
        shelfService.updateCratesAmount(event);
    }

}
