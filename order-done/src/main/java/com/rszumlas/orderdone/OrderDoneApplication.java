package com.rszumlas.orderdone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "com.rszumlas.clients"
)
public class OrderDoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderDoneApplication.class, args);
    }

}
