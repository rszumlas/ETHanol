package com.rszumlas.parceldone;

import com.rszumlas.clients.account.AccountRequest;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@AllArgsConstructor
public class ParcelDoneService {

    private final ParcelDoneRepository parcelDoneRepository;
    private final KafkaTemplate<String, Long> longKafkaTemplate;
    private final KafkaTemplate<String, AccountRequest> accountRequestKafkaTemplate;
    public static final Logger LOGGER = LoggerFactory.getLogger(ParcelDoneService.class);

    public void insertParcelDone(ParcelDoneRequest parcelDoneRequest) {

        parcelDoneRepository.insertParcelDone(parcelDoneRequest);

        //  Update amount of crates in shelf entity
        sendShelfTopicMessage(parcelDoneRequest);

        //  Update amount of eth in account entity
        sendAccountTopicMessage(parcelDoneRequest);
    }

    private void sendShelfTopicMessage(ParcelDoneRequest parcelDoneRequest) {
        Long parcel_id = parcelDoneRequest.parcel_id();
        LOGGER.info(String.format("Message sent -> %s", parcel_id));
        longKafkaTemplate.send("shelf", parcel_id);
    }

    private void sendAccountTopicMessage(ParcelDoneRequest parcelDoneRequest) {
        AccountRequest accountRequest = AccountRequest.builder()
                .id(parcelDoneRequest.account_id())
                .eth_total(calculateEarnedEth(parcelDoneRequest.delivery_time_seconds()))
                .build();

        LOGGER.info(String.format("Message sent -> %s", accountRequest));
        accountRequestKafkaTemplate.send("account", accountRequest);
    }

    private Double calculateEarnedEth(Integer delivery_time_seconds) {
        float plnPerHour = 19.7f;
        int ethPriceInUsd = 1300;
        double usdPerSecond = plnPerHour/4.5 / 3600;
        double ethPerSecond = usdPerSecond/ethPriceInUsd;
        BigDecimal earnedEth = BigDecimal.valueOf(ethPerSecond * delivery_time_seconds).setScale(4, RoundingMode.DOWN);
        return earnedEth.doubleValue();
    }

}