package com.rszumlas.clients.vodka;

public record VodkaRequest(
        String name,
        String flavour,
        Integer bottle_size,
        Double voltage
) {
}
