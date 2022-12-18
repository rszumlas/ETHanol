package com.rszumlas.clients.account;

import lombok.Builder;

@Builder
public record AccountRequest(
        Long id,
        String email,
        String password,
        Double eth_total
) {
}
