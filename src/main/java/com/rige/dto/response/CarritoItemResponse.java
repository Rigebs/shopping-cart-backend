package com.rige.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarritoItemResponse {
    private Long id;
    private Integer cantidad;
    private Long productoId;
    private String productoNombre;
    private String imagenUrl;
    private BigDecimal precio;
    private BigDecimal subtotal;
}
