package com.rige.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductoResponse {
    private Long id;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;
    private String imagenUrl;
}
