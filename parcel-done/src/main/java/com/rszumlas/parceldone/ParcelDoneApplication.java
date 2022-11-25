package com.rszumlas.parceldone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.rszumlas.parceldone",
                "com.rszumlas.parcel",
                "com.rszumlas.employee"
        }
)
@EnableFeignClients(
        basePackages = {
                "com.rszumlas.clients.shelf"
        }
)
public class ParcelDoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParcelDoneApplication.class, args);
    }

}
