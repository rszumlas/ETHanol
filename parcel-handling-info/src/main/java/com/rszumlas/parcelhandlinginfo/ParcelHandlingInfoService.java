package com.rszumlas.parcelhandlinginfo;

import com.rszumlas.clients.parcel.ParcelClient;
import com.rszumlas.clients.parcel.ParcelRequest;
import com.rszumlas.clients.parcelhandlinginfo.ParcelHandlingInfoRequest;
import com.rszumlas.clients.shelf.ShelfClient;
import com.rszumlas.clients.shelf.ShelfRequest;
import com.rszumlas.clients.vodka.VodkaClient;
import com.rszumlas.clients.vodka.VodkaRequest;
import com.rszumlas.parcel.Parcel;
import com.rszumlas.shelf.Shelf;
import com.rszumlas.vodka.Vodka;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ParcelHandlingInfoService {

    private final ParcelHandlingInfoRepository parcelHandlingInfoRepository;
    void insertParcelHandlingInfo(ParcelHandlingInfoRequest parcelHandlingInfoRequest) {
        parcelHandlingInfoRepository.insertParcelHandlingInfo(parcelHandlingInfoRequest);
    }

}
