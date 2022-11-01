package com.rszumlas.clients.shelf;

import com.rszumlas.vodka.Vodka;

public record ShelfRequest(
        int crates,
        int max_crates,
        Vodka vodka
) {
}
