package com.example.Framework.repository;

import com.example.Framework.entity.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Long> {
}
