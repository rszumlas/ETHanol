package com.rszumlas.clients.parcel;

public record ParcelRequest(
        String delivery_type,
        Integer crates,
        Long vodka_id
) {
}