package com.rszumlas.shelf.kafka;

import com.rszumlas.shelf.Shelf;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShelfProducer {

    public static final Logger LOGGER = LoggerFactory.getLogger(ShelfProducer.class);
    private final KafkaTemplate<String, Shelf> kafkaTemplate;

    public void sendMessage(Shelf event) {
        LOGGER.info(String.format("Event sent -> %s", event));
        kafkaTemplate.send("shelf_topic", event);
    }

}
