package com.rige.services.impl;

import com.rige.dto.request.DetallePedidoRequest;
import com.rige.dto.request.PedidoRequest;
import com.rige.dto.response.DetallePedidoResponse;
import com.rige.entities.DetallePedidoEntity;
import com.rige.entities.PedidoEntity;
import com.rige.entities.ProductoEntity;
import com.rige.repositories.IDetallePedidoRepository;
import com.rige.repositories.IPedidoRepository;
import com.rige.repositories.IProductoRepository;
import com.rige.services.IPedidoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PedidoServiceImpl implements IPedidoService {

    private final IPedidoRepository iPedidoRepository;
    private final IDetallePedidoRepository iDetallePedidoRepository;
    private final IProductoRepository iProductoRepository;

    @Override
    public void generarPedido(PedidoRequest pedidoRequest) {
        PedidoEntity pedido = new PedidoEntity();

        pedido.setTotal(pedidoRequest.getTotal());
        pedido.setEstado("PENDIENTE");
        pedido.setFechaPedido(LocalDateTime.now());

        // CApturo el pedido con su ID generado
        pedido = iPedidoRepository.save(pedido);

        //Recorrer la lista de detalles del pedido
        for (DetallePedidoRequest detalle : pedidoRequest.getDetalles()) {

            // RESTO EL STOCK DEL PRODUCTO
            ProductoEntity producto = iProductoRepository.findById(detalle.getProductoId()).get();
            producto.setId(detalle.getProductoId());
            producto.setCantidad(producto.getCantidad() - detalle.getCantidad());
            iProductoRepository.save(producto);

            DetallePedidoEntity detallePedido = new DetallePedidoEntity();
            detallePedido.setCantidad(detalle.getCantidad());
            detallePedido.setSubtotal(detalle.getSubtotal());
            detallePedido.setPedido(pedido);
            detallePedido.setProducto(producto);

            iDetallePedidoRepository.save(detallePedido);
        }
    }

    @Override
    public void pagarPedido(Long pedidoId) {
        PedidoEntity pedido = iPedidoRepository.findById(pedidoId).get();
        pedido.setEstado("PAGADO");
        iPedidoRepository.save(pedido);
    }

    @Override
    public List<DetallePedidoResponse> listarDetalles(Long pedidoId) {
        List<DetallePedidoEntity> detalles = iDetallePedidoRepository.findByPedido_Id(pedidoId);
        List<DetallePedidoResponse> detallesResponse = new ArrayList<>();

        for (DetallePedidoEntity detalle : detalles) {
            DetallePedidoResponse response = new DetallePedidoResponse();
            response.setCantidad(detalle.getCantidad());
            response.setProducto(detalle.getProducto().getNombre());
            response.setPrecio(detalle.getProducto().getPrecio());
            response.setSubtotal(detalle.getSubtotal());

            detallesResponse.add(response);
        }
        return detallesResponse;
    }


    @Override
    public void cancelarPedido(Long pedidoId) {
        PedidoEntity pedido = iPedidoRepository.findById(pedidoId).get();
        pedido.setEstado("CANCELADO");
        iPedidoRepository.save(pedido);
    }
}
