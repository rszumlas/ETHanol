package com.rszumlas.clients.parceldone;

public record ParcelDoneRequest(
        Long parcel_id,
        Long account_id,
        String delivery_time,
        Double eth_earned,
        Boolean is_finished
) {
}
