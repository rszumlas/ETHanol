package com.rszumlas.vodka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.rszumlas.vodka"
        }
)
public class VodkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(VodkaApplication.class, args);
    }
}
