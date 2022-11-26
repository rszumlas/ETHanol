package com.rszumlas.clients.account;

public record AccountRequest(
        String email,
        String password,
        Double eth_total
) {
}
