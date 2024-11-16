package com.example.Framework.repository;

import com.example.Framework.entity.EstadoPrestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoPrestamoRepository extends JpaRepository<EstadoPrestamo, Long> {
}
