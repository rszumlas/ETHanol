package com.rszumlas.clients.parcel;

public record ParcelRequest(
        Long parcel_type_id,
        Integer crates,
        Long vodka_id
) {
}