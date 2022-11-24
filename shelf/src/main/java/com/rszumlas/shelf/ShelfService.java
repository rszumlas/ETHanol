package com.rszumlas.shelf;

import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.shelf.ShelfRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ShelfService {

    private final ShelfRepository shelfRepository;

    public Optional<ShelfRequest> findShelfByVodkaId(Long vodka_id) {
        return shelfRepository.findShelfByVodkaId(vodka_id);
    }

    public void updateCratesAmount(ParcelRequest parcelRequest) {
        shelfRepository.updateCratesAmount(parcelRequest.crates(), parcelRequest.vodka_id());
    }

}
