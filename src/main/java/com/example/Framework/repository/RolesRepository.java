package com.example.Framework.repository;

import com.example.Framework.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
}
