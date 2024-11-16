package com.example.Framework.repository;

import com.example.Framework.entity.EstadoInventarioEjemplares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoInventarioEjemplaresRepository extends JpaRepository<EstadoInventarioEjemplares, Long> {
}
