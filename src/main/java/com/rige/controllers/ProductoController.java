package com.rige.controllers;

import com.rige.dto.response.ProductoResponse;
import com.rige.services.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("productos")
@AllArgsConstructor
public class ProductoController {
    private final IProductoService iProductoService;

    @GetMapping
    public List<ProductoResponse> listarProductos() {
        return iProductoService.listarProductos();
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<ProductoResponse> listarProductosPorCategoria(@PathVariable Long categoriaId) {
        return iProductoService.listarPorCategoria(categoriaId);
    }
}
