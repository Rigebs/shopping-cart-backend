package com.rige.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetallePedidoResponse {
    private Integer cantidad;
    private String producto;
    private BigDecimal precio;
    private BigDecimal subtotal;
}
