package com.rszumlas.orderhandlinginfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "com.rszumlas.clients"
)
public class OrderHandlingInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderHandlingInfoApplication.class, args);
    }

}
