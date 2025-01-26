package com.rige.dto.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PedidoRequest {
    private BigDecimal total;
    private List<DetallePedidoRequest> detalles;
}
