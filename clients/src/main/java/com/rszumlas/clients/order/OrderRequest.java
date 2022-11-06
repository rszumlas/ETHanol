package com.rszumlas.clients.order;


import com.rszumlas.ordertype.OrderType;
import com.rszumlas.vodka.Vodka;

public record OrderRequest(
        OrderType orderType,
        int crates,
        Vodka vodka
) {
}