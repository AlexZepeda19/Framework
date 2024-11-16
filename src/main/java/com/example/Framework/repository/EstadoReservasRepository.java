package com.example.Framework.repository;

import com.example.Framework.entity.EstadoReservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoReservasRepository extends JpaRepository<EstadoReservas, Long> {
}
