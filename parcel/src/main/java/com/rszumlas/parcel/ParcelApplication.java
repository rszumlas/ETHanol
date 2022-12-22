package com.rszumlas.parcel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.rszumlas.parcel",
                "com.rszumlas.vodka"
        }
)
@EnableFeignClients(
        basePackages = {
                "com.rszumlas.clients.shelf"
        }
)
@EnableEurekaClient
public class ParcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParcelApplication.class, args);
    }

}
