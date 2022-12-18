package com.rszumlas.account.kafka;

import com.rszumlas.account.AccountService;
import com.rszumlas.clients.account.AccountRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaListeners {

    private final AccountService accountService;
    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(
            topics = "account",
            groupId = "accountGroup"
    )
    void listener(AccountRequest data) {
        LOGGER.info(String.format("Message received -> %s", data));
        accountService.updateEthTotal(data);
    }

}
