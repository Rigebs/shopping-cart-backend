package com.rige.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CarritoResponse {
    BigDecimal total;
    List<CarritoItemResponse> items;
}
