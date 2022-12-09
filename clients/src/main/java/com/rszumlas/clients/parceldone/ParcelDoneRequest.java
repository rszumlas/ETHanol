package com.rszumlas.clients.parceldone;

public record ParcelDoneRequest(
        Long parcel_id,
        Long account_id,
        Integer delivery_time_seconds,
        Boolean is_finished
) {
}
