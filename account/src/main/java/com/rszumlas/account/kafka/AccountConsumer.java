package com.rszumlas.account.kafka;

import com.rszumlas.account.AccountService;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountConsumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(AccountConsumer.class);
    private final AccountService accountService;

    @KafkaListener(
            topics = "parcel_done_request_topic",
            groupId = "accountGroup"
    )
    public void consume(ParcelDoneRequest event) {
        LOGGER.info(String.format("Event received -> %s", event));
        accountService.updateEthTotal(event);
    }

}
