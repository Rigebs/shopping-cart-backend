package com.rige.controllers;

import com.rige.dto.request.PedidoRequest;
import com.rige.dto.response.ApiResponse;
import com.rige.dto.response.DetallePedidoResponse;
import com.rige.services.IPedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedidos")
@AllArgsConstructor
public class PedidoController {
    private final IPedidoService iPedidoService;

    @PostMapping
    public ApiResponse generarPedido(@RequestBody PedidoRequest pedidoRequest) {
        iPedidoService.generarPedido(pedidoRequest);
        return new ApiResponse("Pedido generado correctamente", null);
    }

    @PostMapping("/{pedidoId}/pagar")
    public ApiResponse pagarPedido(@PathVariable Long pedidoId) {
        iPedidoService.pagarPedido(pedidoId);
        return new ApiResponse("Pedido pagado correctamente", null);
    }

    @GetMapping("/{pedidoId}")
    public List<DetallePedidoResponse> listarDetalles(@PathVariable Long pedidoId) {
        return iPedidoService.listarDetalles(pedidoId);
    }

    @PostMapping("/{pedidoId}/cancelar")
    public ApiResponse cancelarPedido(@PathVariable Long pedidoId) {
        iPedidoService.cancelarPedido(pedidoId);
        return new ApiResponse("Pedido cancelado correctamente", null);
    }
}
