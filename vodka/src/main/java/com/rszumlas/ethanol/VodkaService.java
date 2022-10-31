package com.rszumlas.ethanol;

import org.springframework.stereotype.Service;

@Service
public class VodkaService {

    private final VodkaRepository vodkaRepository;

    public VodkaService(VodkaRepository vodkaRepository) {
        this.vodkaRepository = vodkaRepository;
    }

}
