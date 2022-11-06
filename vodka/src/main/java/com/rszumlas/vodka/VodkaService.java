package com.rszumlas.vodka;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VodkaService {

    private final VodkaRepository vodkaRepository;

}
