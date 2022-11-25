package com.rszumlas.parcelaccepted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.rszumlas.parcel",
                "com.rszumlas.parceldone",
                "com.rszumlas.account"
        }
)
public class ParcelAcceptedApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParcelAcceptedApplication.class, args);
    }

}
