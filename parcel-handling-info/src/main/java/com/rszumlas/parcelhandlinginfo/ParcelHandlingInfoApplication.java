package com.rszumlas.parcelhandlinginfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.rszumlas.parcel",
                "com.rszumlas.shelf",
                "com.rszumlas.parcelhandlinginfo"
        }
)
public class ParcelHandlingInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParcelHandlingInfoApplication.class, args);
    }

}
