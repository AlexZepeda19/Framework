package com.example.Framework.repository;

import com.example.Framework.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
}
