package com.rszumlas.clients.account;

import lombok.Builder;

@Builder
public record AccountRequest(
        String email,
        String password,
        Double eth_total
) {
}
