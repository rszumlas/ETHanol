package com.rszumlas.clients.shelf;

public record ShelfRequest(
        Integer crates,
        Integer max_crates,
        Long vodka_id
) {
}
