package com.rszumlas.clients.vodka;

public record VodkaRequest(
        String name,
        Integer bottle_size,
        Double voltage
) {
}
