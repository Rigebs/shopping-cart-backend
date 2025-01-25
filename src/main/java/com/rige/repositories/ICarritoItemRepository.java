package com.rige.repositories;

import com.rige.entities.CarritoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoItemRepository extends JpaRepository<CarritoItemEntity, Long> {
}
