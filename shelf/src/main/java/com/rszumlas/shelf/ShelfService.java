package com.rszumlas.shelf;

import com.rszumlas.clients.order.OrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ShelfService {

    private final ShelfRepository shelfRepository;

    public Optional<Shelf> findByVodkaId(Long vodka_id) {
        return shelfRepository.findByVodkaId(vodka_id);
    }

    public void updateCratesAmount(OrderRequest orderRequest) {
        shelfRepository.updateCratesAmount(orderRequest.crates(), orderRequest.vodka().getId());
    }

}
