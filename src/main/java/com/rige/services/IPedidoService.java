package com.rige.services;

import com.rige.dto.request.PedidoRequest;
import com.rige.entities.DetallePedidoEntity;
import com.rige.entities.PedidoEntity;

import java.util.List;

public interface IPedidoService {
    void generarPedido(PedidoRequest pedidoRequest);
    void pagarPedido(Long pedidoId);
    List<DetallePedidoEntity> listarDetalles(Long pedidoId);
    void cancelarPedido(Long pedidoId);
}
