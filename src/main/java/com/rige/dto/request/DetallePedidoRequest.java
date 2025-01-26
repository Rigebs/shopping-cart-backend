package com.rige.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetallePedidoRequest {
    private Integer cantidad;
    private BigDecimal subtotal;
    private Long productoId;
}
