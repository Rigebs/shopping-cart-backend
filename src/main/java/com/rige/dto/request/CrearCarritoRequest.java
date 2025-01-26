package com.rige.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CrearCarritoRequest {
    BigDecimal total;
    Integer cantidad;
    Long productoId;
}
