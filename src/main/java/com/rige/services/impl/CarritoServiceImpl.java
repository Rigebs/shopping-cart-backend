package com.rige.services.impl;

import com.rige.dto.request.AgregarItemRequest;
import com.rige.dto.request.CrearCarritoRequest;
import com.rige.dto.response.CarritoItemResponse;
import com.rige.dto.response.CarritoResponse;
import com.rige.entities.CarritoEntity;
import com.rige.entities.CarritoItemEntity;
import com.rige.entities.ProductoEntity;
import com.rige.repositories.ICarritoItemRepository;
import com.rige.repositories.ICarritoRepository;
import com.rige.services.ICarritoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CarritoServiceImpl implements ICarritoService {

    private final ICarritoRepository iCarritoRepository;
    private final ICarritoItemRepository iCarritoItemRepository;

    @Override
    public void nuevoCarrito(CrearCarritoRequest carritoRequest) {
        CarritoEntity carrito = new CarritoEntity();
        carrito.setTotal(carritoRequest.getTotal());
        carrito.setUltimaActualizacion(LocalDateTime.now());

        // Capturo el carrito con su ID generado
        carrito = iCarritoRepository.save(carrito);

        // Obtengo el producto desde la base de datos
        ProductoEntity producto = new ProductoEntity();
        producto.setId(carritoRequest.getProductoId());

        CarritoItemEntity carritoItem = new CarritoItemEntity();
        carritoItem.setCantidad(carritoRequest.getCantidad());
        carritoItem.setCarrito(carrito);
        carritoItem.setProducto(producto);
        iCarritoItemRepository.save(carritoItem);
    }

    @Override
    public CarritoResponse obtenerCarrito(Long carritoId) {
        CarritoEntity carritoEntity = iCarritoRepository.findById(carritoId).get();
        List<CarritoItemEntity> items = iCarritoItemRepository.findByCarrito_Id(carritoId);
        
        List<CarritoItemResponse> itemLista = new ArrayList<>();
        for (CarritoItemEntity item : items) {
            CarritoItemResponse itemResponse = obtenerInfoItem(item);
            itemLista.add(itemResponse);
        }

        CarritoResponse carritoResponse = new CarritoResponse();
        carritoResponse.setTotal(carritoEntity.getTotal());
        carritoResponse.setItems(itemLista);
        
        return carritoResponse;
    }

    private static CarritoItemResponse obtenerInfoItem(CarritoItemEntity item) {
        CarritoItemResponse itemResponse = new CarritoItemResponse();
        itemResponse.setId(item.getId());
        itemResponse.setCantidad(item.getCantidad());
        itemResponse.setProductoId(item.getProducto().getId());
        itemResponse.setProductoNombre(item.getProducto().getNombre());
        itemResponse.setImagenUrl(item.getProducto().getImagenUrl());
        itemResponse.setPrecio(item.getProducto().getPrecio());
        itemResponse.setSubtotal(item.getProducto().getPrecio().multiply(BigDecimal.valueOf(item.getCantidad())));
        return itemResponse;
    }

    @Override
    public void agregarItem(AgregarItemRequest item) {
        CarritoItemEntity carritoItem = new CarritoItemEntity();
        carritoItem.setCantidad(item.getCantidad());

        ProductoEntity producto = new ProductoEntity();
        producto.setId(item.getProductoId());

        CarritoEntity carrito = new CarritoEntity();
        carrito.setId(item.getCarritoId());

        carritoItem.setProducto(producto);
        carritoItem.setCarrito(carrito);
        iCarritoItemRepository.save(carritoItem);
    }

    @Override
    public void actualizarCantidad(Long itemId, Integer cantidad) {
        CarritoItemEntity carritoItem = iCarritoItemRepository.findById(itemId).get();
        carritoItem.setCantidad(cantidad);
        iCarritoItemRepository.save(carritoItem);
    }

    @Override
    public void quitarItem(Long itemId) {
        iCarritoItemRepository.deleteById(itemId);
    }
}
