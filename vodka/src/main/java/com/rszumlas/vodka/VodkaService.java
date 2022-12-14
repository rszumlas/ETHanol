package com.rszumlas.vodka;

import com.rszumlas.clients.vodka.VodkaRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VodkaService {

    private final VodkaRepository vodkaRepository;

    public Vodka findVodkaById (Long vodka_id) {
        return vodkaRepository.findVodkaById(vodka_id);
    }

}
