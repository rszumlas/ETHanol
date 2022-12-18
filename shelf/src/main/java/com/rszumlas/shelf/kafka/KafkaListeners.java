package com.rszumlas.shelf.kafka;

import com.rszumlas.shelf.ShelfService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaListeners {

    private final ShelfService shelfService;
    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(
            topics = "shelf",
            groupId = "shelfGroup"
    )
    void listener(Long data) {
        LOGGER.info(String.format("Message received -> %s", data));
        shelfService.updateCratesAmount(data);
    }

}
