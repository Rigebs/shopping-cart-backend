package com.rige.repositories;

import com.rige.entities.CarritoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarritoItemRepository extends JpaRepository<CarritoItemEntity, Long> {
    List<CarritoItemEntity> findByCarrito_Id(Long id);
}
