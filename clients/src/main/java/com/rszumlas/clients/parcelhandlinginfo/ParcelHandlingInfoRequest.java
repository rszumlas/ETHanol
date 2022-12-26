package com.rszumlas.clients.parcelhandlinginfo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public final class ParcelHandlingInfoRequest {

    private Long parcel_id;
    private Long shelf_id;
    private Integer crates;
    private LocalDateTime created_at;

}
