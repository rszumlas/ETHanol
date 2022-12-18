package com.rszumlas.account.kafka;

import com.rszumlas.account.AccountService;
import com.rszumlas.clients.account.AccountRequest;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaListeners {

    private final AccountService accountService;

    @KafkaListener(
            topics = "account",
            groupId = "account"
    )
    void listener(AccountRequest data) {
        accountService.updateEthTotal(data);
    }

}
