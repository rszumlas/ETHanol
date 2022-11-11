package com.rszumlas.vodka;

import com.rszumlas.clients.ordertype.OrderTypeRequest;
import com.rszumlas.clients.vodka.VodkaRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VodkaService {

    private final VodkaRepository vodkaRepository;

    public VodkaRequest findById (Integer vodka_id) {
        return vodkaRepository.findById(vodka_id);
    }

}
