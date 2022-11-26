package com.rszumlas.parceldone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.rszumlas.parceldone",
                "com.rszumlas.parcel",
                "com.rszumlas.account"
        }
)
@EnableFeignClients(
        basePackages = {
                "com.rszumlas.clients.shelf",
                "com.rszumlas.clients.account"
        }
)
public class ParcelDoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParcelDoneApplication.class, args);
    }

}
