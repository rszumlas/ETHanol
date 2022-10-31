package com.rszumlas.ethanol;

import org.springframework.stereotype.Service;

@Service
public class ProfessionService {

    private final ProfessionRepository professionRepository;

    public ProfessionService(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

}
