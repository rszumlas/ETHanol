package com.rszumlas.parceldone;

import com.rszumlas.account.Account;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import com.rszumlas.parcel.Parcel;
import com.rszumlas.parceldone.kafka.ParcelDoneRequestProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelDoneService {

    private final ParcelDoneRepository parcelDoneRepository;
    private final ParcelDoneRequestProducer parcelDoneRequestProducer;

    public Boolean checkIfFinished(Long parcel_id) {
        return parcelDoneRepository.checkIfFinished(parcel_id);
    }

    public void saveParcelDone(ParcelDoneRequest parcelDoneRequest) {
        parcelDoneRepository.save(new ParcelDone(
                null,
                new Parcel(parcelDoneRequest.parcel_id()),
                new Account(parcelDoneRequest.account_id()),
                parcelDoneRequest.delivery_time_seconds(),
                parcelDoneRequest.is_finished()
        ));
        parcelDoneRequestProducer.sendMessage(parcelDoneRequest);
    }

}