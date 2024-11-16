package com.example.Framework.repository;

import com.example.Framework.entity.InventarioEjemplares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioEjemplaresRepository extends JpaRepository <InventarioEjemplares, Long>{
}
