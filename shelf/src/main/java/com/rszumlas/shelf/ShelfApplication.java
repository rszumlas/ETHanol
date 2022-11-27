package com.rszumlas.shelf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.rszumlas.shelf",
                "com.rszumlas.vodka"
        }
)
@EnableFeignClients(
        basePackages = {
                "com.rszumlas.clients.parcel",
        }
)
public class ShelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelfApplication.class, args);
    }

}
