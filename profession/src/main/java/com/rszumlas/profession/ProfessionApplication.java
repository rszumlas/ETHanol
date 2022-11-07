package com.rszumlas.profession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(
        basePackages = "com.rszumlas.clients"
)
public class ProfessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfessionApplication.class, args);
    }

}
