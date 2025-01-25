package com.rige.services;

import com.rige.entities.CarritoItemEntity;

import java.util.List;

public interface ICarritoService {
    void nuevoCarrito(CarritoItemEntity carritoItem);
    List<CarritoItemEntity> listarItems(Long carritoId);
    void agregarItem(CarritoItemEntity carritoItem);
}
