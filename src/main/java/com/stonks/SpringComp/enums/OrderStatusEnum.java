package com.stonks.SpringComp.enums;

public enum OrderStatusEnum {
    OPEN,           // 0 aberto
    CONFIRMED,      // 1 Confirmado pelo restaurante
    IN_TRANSIT,     // 2 Em transito
    COMPLETE,       // 3 Entregue

    EXPIRED,        // 4 Expirado
    CANCELED,       // 5 Cancelado
    ERROR           // 6 Error :(
}
