package com.rige.services;

import com.rige.dto.request.AgregarItemRequest;
import com.rige.dto.request.CrearCarritoRequest;
import com.rige.dto.response.CarritoResponse;

public interface ICarritoService {
    Long nuevoCarrito(CrearCarritoRequest carritoRequest);
    CarritoResponse obtenerCarrito(Long carritoId);
    void agregarItem(AgregarItemRequest item);
    void actualizarCantidad(Long itemId, Integer cantidad);
    void quitarItem(Long itemId);
}