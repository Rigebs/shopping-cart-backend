package com.rige.repositories;

import com.rige.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<ProductoEntity, Long> {
    List<ProductoEntity> findByCantidadGreaterThan(int cantidad);
}
