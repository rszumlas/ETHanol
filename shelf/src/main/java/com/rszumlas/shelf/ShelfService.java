package com.rszumlas.shelf;

import com.rszumlas.clients.order.OrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ShelfService {

    private final ShelfRepository shelfRepository;

    public void updateCratesAmount(OrderRequest orderRequest) {
        shelfRepository.updateCratesAmount(orderRequest.crates(), orderRequest.vodka().getId());
    }

}
