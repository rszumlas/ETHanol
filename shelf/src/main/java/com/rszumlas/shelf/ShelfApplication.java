package com.rszumlas.shelf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.rszumlas.shelf",
                "com.rszumlas.vodka",
                "com.rszumlas.parcel"
        }
)
@EnableFeignClients(
        basePackages = {
                "com.rszumlas.clients.parcel",
        }
)
@EnableEurekaClient
public class ShelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelfApplication.class, args);
    }

}
