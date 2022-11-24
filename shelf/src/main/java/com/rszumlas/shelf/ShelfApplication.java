package com.rszumlas.shelf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.rszumlas.shelf",
                "com.rszumlas.vodka"
        }
)
public class ShelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShelfApplication.class, args);
    }

}
