package com.rszumlas.shelf;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ShelfService {

    private final ShelfRepository shelfRepository;

    public Optional<Shelf> findByVodkaId(Integer vodka_id) {
        return shelfRepository.findByVodkaId(vodka_id);
    }

//    public void updateCratesAmount(OrderRequest orderRequest) {
//        shelfRepository.updateCratesAmount(orderRequest.crates(), orderRequest.vodka().getId());
//    }

}
