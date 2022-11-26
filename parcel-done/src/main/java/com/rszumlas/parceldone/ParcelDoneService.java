package com.rszumlas.parceldone;

import com.rszumlas.clients.account.AccountClient;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import com.rszumlas.clients.shelf.ShelfClient;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ParcelDoneService {

    private final ParcelDoneRepository parcelDoneRepository;
    private final ShelfClient shelfClient;
    private final AccountClient accountClient;

    public void insertParcelDone(ParcelDoneRequest parcelDoneRequest) {
        saveParcelDone(parcelDoneRequest);
        shelfClient.updateCratesAmount(parcelDoneRequest.parcel_id());
        accountClient.updateEthTotal(parcelDoneRequest.account_id());
    }

    private void saveParcelDone(ParcelDoneRequest parcelDoneRequest) {
        ModelMapper modelMapper = new ModelMapper();
        ParcelDone parcelDone = modelMapper.map(parcelDoneRequest, ParcelDone.class);
        parcelDoneRepository.save(parcelDone);
    }

    public Optional<ParcelDoneRequest> findParcelDoneByAccountId(Long account_id) {
        return parcelDoneRepository.findParcelDoneByAccountId(account_id);
    }

}