package com.rszumlas.parceldone;

import com.rszumlas.amqp.RabbitMQMessageProducer;
import com.rszumlas.clients.account.AccountClient;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import com.rszumlas.clients.shelf.ShelfClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@AllArgsConstructor
public class ParcelDoneService {

    private final ParcelDoneRepository parcelDoneRepository;
    private final ShelfClient shelfClient;
    private final AccountClient accountClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public void insertParcelDone(ParcelDoneRequest parcelDoneRequest) {
        parcelDoneRepository.insertParcelDone(parcelDoneRequest);
        shelfClient.updateCratesAmount(parcelDoneRequest.parcel_id());
        accountClient.updateEthTotal(parcelDoneRequest.account_id(), calculateEarnedEth(parcelDoneRequest.delivery_time_seconds()));
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