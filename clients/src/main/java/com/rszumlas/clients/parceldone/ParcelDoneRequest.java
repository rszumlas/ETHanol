package com.rszumlas.clients.parceldone;

import java.sql.Time;

public record ParcelDoneRequest(
        Long parcel_id,
        Long employee_id,
        Time delivery_time,
        Double eth_earned
) {
}