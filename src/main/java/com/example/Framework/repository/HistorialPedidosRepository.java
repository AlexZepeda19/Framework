package com.example.Framework.repository;

import com.example.Framework.entity.HistorialPedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialPedidosRepository extends JpaRepository <HistorialPedidos, Long> {
}
