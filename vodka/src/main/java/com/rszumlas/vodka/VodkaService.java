package com.rszumlas.vodka;

import org.springframework.stereotype.Service;

@Service
public class VodkaService {

    private final VodkaRepository vodkaRepository;

    public VodkaService(VodkaRepository vodkaRepository) {
        this.vodkaRepository = vodkaRepository;
    }

}
