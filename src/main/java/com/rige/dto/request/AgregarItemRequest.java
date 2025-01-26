package com.rige.dto.request;

import lombok.Data;

@Data
public class AgregarItemRequest {
    Integer cantidad;
    Long productoId;
    Long carritoId;
}
