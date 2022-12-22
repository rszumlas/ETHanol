package com.rszumlas.shelf;

import com.rszumlas.clients.parcel.ParcelClient;
import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShelfService {

    private final ShelfRepository shelfRepository;
    private final ParcelClient parcelClient;
    public static final Logger LOGGER = LoggerFactory.getLogger(ShelfService.class);

    // findShelIdfByVodkaId
    public Long findShelIdfByVodkaId(Long vodka_id) {
        return shelfRepository.findShelfIdByVodkaId(vodka_id);
    }

    // findShelfById
    public Shelf findShelfById(Long shelf_id) {
        return shelfRepository.findById(shelf_id).orElseThrow();
    }

    // updateCratesAmount
    public void updateCratesAmount(ParcelDoneRequest parcelDoneRequest) {
        ParcelRequest parcelRequest = parcelClient.findParcelById(parcelDoneRequest.parcel_id());
        increaseOrDecreaseCratesAmount(parcelDoneRequest, parcelRequest);
    }

    private void increaseOrDecreaseCratesAmount(ParcelDoneRequest parcelDoneRequest, ParcelRequest parcelRequest) {
        Boolean is_finished = parcelDoneRequest.is_finished();

        if (is_finished && parcelRequest.delivery_type().equals("IMPORT")) {
            LOGGER.info(String.format("Increase crates amount by %s", parcelRequest.crates()));
            shelfRepository.increaseCratesAmount(parcelRequest.crates(), parcelRequest.vodka_id());
        }
        if (is_finished && parcelRequest.delivery_type().equals("EXPORT")){
            LOGGER.info(String.format("Decrease crates amount by %s", parcelRequest.crates()));
            shelfRepository.decreaseCratesAmount(parcelRequest.crates(), parcelRequest.vodka_id());
        }
    }

}
