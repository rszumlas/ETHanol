package com.rszumlas.orderaccepted;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "com.rszumlas.clients"
)
public class OrderAcceptedApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderAcceptedApplication.class, args);
    }

}
