package com.rszumlas.parceldone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.rszumlas.parceldone",
                "com.rszumlas.parcel",
                "com.rszumlas.employee"
        }
)
public class ParcelDoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParcelDoneApplication.class, args);
    }

}
