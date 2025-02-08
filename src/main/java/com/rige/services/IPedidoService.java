package com.rige.services;

import com.rige.dto.request.PedidoRequest;
import com.rige.dto.response.DetallePedidoResponse;

import java.util.List;

public interface IPedidoService {
    void generarPedido(PedidoRequest pedidoRequest);
    void pagarPedido(Long pedidoId);
    List<DetallePedidoResponse> listarDetalles(Long pedidoId);
    void cancelarPedido(Long pedidoId);
}
