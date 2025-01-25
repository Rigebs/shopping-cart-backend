package com.rige.repositories;

import com.rige.entities.CarritoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoRepository extends JpaRepository<CarritoEntity, Long> {
}
