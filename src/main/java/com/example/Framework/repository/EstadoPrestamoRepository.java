package com.example.Framework.repository;

import com.example.Framework.entity.EstadoPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPrestamoRepository extends JpaRepository<EstadoPrestamo, Long> {
}
