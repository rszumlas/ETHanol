package com.rszumlas.parceldone;

import com.rszumlas.clients.parcel.ParcelClient;
import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import com.rszumlas.clients.shelf.ShelfClient;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParcelDoneService {

    private final ShelfClient shelfClient;
    private final ParcelClient parcelClient;
    private final ParcelDoneRepository parcelDoneRepository;

    public void insertParcelDone(ParcelDoneRequest parcelDoneRequest) {

        ModelMapper modelMapper = new ModelMapper();
        ParcelDone parcelDone = modelMapper.map(parcelDoneRequest, ParcelDone.class);
        parcelDoneRepository.save(parcelDone);

        ParcelRequest parcelRequest = parcelClient.findParcelById(parcelDoneRequest.parcel_id());
        shelfClient.updateCratesAmount(parcelRequest);
    }

}