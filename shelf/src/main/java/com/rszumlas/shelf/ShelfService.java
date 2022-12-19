package com.rszumlas.shelf;

import com.rszumlas.clients.parcel.ParcelClient;
import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.parceldone.ParcelDoneClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShelfService {

    private final ShelfRepository shelfRepository;
    private final ParcelClient parcelClient;
    private final ParcelDoneClient parcelDoneClient;

    public Long findShelIdfByVodkaId(Long vodka_id) {
        return shelfRepository.findShelfIdByVodkaId(vodka_id);
    }

    public Shelf findShelfById(Long shelf_id) {
        return shelfRepository.findById(shelf_id).orElseThrow();
    }

    public void updateCratesAmount(Long parcel_id) {
        ParcelRequest parcelRequest = parcelClient.findParcelById(parcel_id);
        Boolean is_finished = parcelDoneClient.checkIfFinished(parcel_id);

        if (is_finished && parcelRequest.delivery_type().equals("IMPORT")) {
            shelfRepository.increaseCratesAmount(parcelRequest.crates(), parcelRequest.vodka_id());
        }
        if (!is_finished && parcelRequest.delivery_type().equals("EXPORT")){
            shelfRepository.decreaseCratesAmount(parcelRequest.crates(), parcelRequest.vodka_id());
        }
    }

}
