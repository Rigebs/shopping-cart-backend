package com.rige.controllers;

import com.rige.dto.request.AgregarItemRequest;
import com.rige.dto.request.CrearCarritoRequest;
import com.rige.dto.response.ApiResponse;
import com.rige.dto.response.CarritoResponse;
import com.rige.services.ICarritoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carritos")
@AllArgsConstructor
public class CarritoController {

    private final ICarritoService iCarritoService;

    @PostMapping
    public ApiResponse nuevoCarrito(@RequestBody CrearCarritoRequest carritoRequest) {
        Long carritoId = iCarritoService.nuevoCarrito(carritoRequest);
        return new ApiResponse("Carrito creado correctamente", carritoId);
    }

    @GetMapping("/{carritoId}")
    public CarritoResponse obtenerCarrito(@PathVariable Long carritoId) {
        return iCarritoService.obtenerCarrito(carritoId);
    }

    @PostMapping("/items")
    public ApiResponse agregarItem(@RequestBody AgregarItemRequest itemRequest) {
        iCarritoService.agregarItem(itemRequest);
        return new ApiResponse("Item agregado correctamente", null);
    }

    @PutMapping("/items/{itemId}")
    public ApiResponse actualizarCantidad(@PathVariable Long itemId, @RequestParam Integer cantidad) {
        iCarritoService.actualizarCantidad(itemId, cantidad);
        return new ApiResponse("Cantidad actualizada correctamente", null);
    }

    @DeleteMapping("/items/{itemId}")
    public ApiResponse quitarItem(@PathVariable Long itemId) {
        iCarritoService.quitarItem(itemId);
        return new ApiResponse("Item quitado correctamente", null);
    }
}
