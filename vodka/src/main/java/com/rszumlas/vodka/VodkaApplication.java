package com.rszumlas.vodka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
