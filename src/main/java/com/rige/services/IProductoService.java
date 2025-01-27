package com.rige.services;

import com.rige.dto.response.ProductoResponse;

import java.util.List;

public interface IProductoService {
    List<ProductoResponse> listarProductos();
}
