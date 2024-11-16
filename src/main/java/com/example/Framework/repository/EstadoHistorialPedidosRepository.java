package com.example.Framework.repository;

import com.example.Framework.entity.EstadoHistorialPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoHistorialPedidosRepository extends JpaRepository<EstadoHistorialPedidos, Long> {
}
