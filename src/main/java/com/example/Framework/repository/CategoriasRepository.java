package com.example.Framework.repository;

import com.example.Framework.entity.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
}
