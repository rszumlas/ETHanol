package com.rszumlas.ethanol;

import org.springframework.stereotype.Service;

@Service
public class ShelfService {

    private final ShelfRepository shelfRepository;

    public ShelfService(ShelfRepository shelfRepository) {
        this.shelfRepository = shelfRepository;
    }

}
