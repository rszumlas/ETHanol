package com.rszumlas.clients.parcel;

import java.time.LocalDateTime;

public record ParcelRequest(
        String delivery_type,
        Integer crates,
        Long vodka_id,
        LocalDateTime created_at
) {
}