package com.rige.services.impl;

import com.rige.dto.response.ProductoResponse;
import com.rige.entities.ProductoEntity;
import com.rige.repositories.IProductoRepository;
import com.rige.services.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    private final IProductoRepository iProductoRepository;

    @Override
    public List<ProductoResponse> listarProductos() {
        List<ProductoEntity> listaEntidad = iProductoRepository.findByCantidadGreaterThan(0);
        List<ProductoResponse> listaConvertida = new ArrayList<>();

        for (ProductoEntity producto : listaEntidad) {
            ProductoResponse productoResponse = new ProductoResponse();
            productoResponse.setId(producto.getId());
            productoResponse.setNombre(producto.getNombre());
            productoResponse.setCantidad(producto.getCantidad());
            productoResponse.setPrecio(producto.getPrecio());
            productoResponse.setImagenUrl(producto.getImagenUrl());
            listaConvertida.add(productoResponse);
        }

        return listaConvertida;
    }
}
