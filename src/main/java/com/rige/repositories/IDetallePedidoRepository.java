package com.rige.repositories;

import com.rige.entities.DetallePedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetallePedidoRepository extends JpaRepository<DetallePedidoEntity, Long> {
    List<DetallePedidoEntity> findByPedido_Id(Long id);
}
