package com.rszumlas.parcelhandlinginfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.rszumlas.parcel",
                "com.rszumlas.shelf",
                "com.rszumlas.parcelhandlinginfo",
                "com.rszumlas.kafka"
        }
)
@EnableEurekaClient
public class ParcelHandlingInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParcelHandlingInfoApplication.class, args);
    }

}
