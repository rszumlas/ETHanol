package com.rszumlas.shelf;

import com.rszumlas.clients.parcel.ParcelClient;
import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.shelf.ShelfRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ShelfService {

    private final ShelfRepository shelfRepository;
    private final ParcelClient parcelClient;

    public Long findShelIdfByVodkaId(Long vodka_id) {
        return shelfRepository.findShelIdfByVodkaId(vodka_id);
    }

    public Shelf findShelfById(Long shelf_id) {
        return shelfRepository.findById(shelf_id).orElseThrow();
    }

    public void updateCratesAmount(Long parcel_id) {
        ParcelRequest parcelRequest = parcelClient.findParcelById(parcel_id);
        shelfRepository.updateCratesAmount(parcelRequest.crates(), parcelRequest.vodka_id());
    }

}
