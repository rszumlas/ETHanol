package com.rszumlas.vodka;

import com.rszumlas.clients.vodka.VodkaRequest;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VodkaService {

    private final VodkaRepository vodkaRepository;

    public VodkaRequest findVodkaById (Long vodka_id) {
//        ModelMapper modelMapper = new ModelMapper();
//        Vodka vodka = .get();
        return vodkaRepository.findVodkaById(vodka_id);
    }

}
