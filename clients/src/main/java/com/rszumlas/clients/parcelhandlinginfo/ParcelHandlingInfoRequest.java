package com.rszumlas.clients.parcelhandlinginfo;

import java.time.LocalDateTime;

public record ParcelHandlingInfoRequest(
        Long parcel_id,
        Long shelf_id,
        Integer crates,
        LocalDateTime created_at
) {
}
