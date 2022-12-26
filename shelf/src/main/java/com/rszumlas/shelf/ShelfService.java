package com.rszumlas.shelf;

import com.rszumlas.clients.parcel.ParcelClient;
import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.parceldone.ParcelDoneRequest;
import com.rszumlas.shelf.kafka.ShelfProducer;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShelfService {

    public static final Logger LOGGER = LoggerFactory.getLogger(ShelfProducer.class);
    private final ShelfRepository shelfRepository;
    private final ParcelClient parcelClient;
    private final ShelfProducer shelfProducer;

    // findShelfById
    public Shelf findShelfById(Long shelf_id) {
        return shelfRepository.findById(shelf_id).orElseThrow();
    }

    // findShelfByVodkaId
    public void findShelfByVodkaId(Long vodka_id) {
        Shelf shelf = shelfRepository.findShelfByVodkaId(vodka_id);
        shelfProducer.sendMessage(shelf);
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
