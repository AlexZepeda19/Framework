package com.example.Framework.repository;

import com.example.Framework.entity.Token;
import com.example.Framework.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String token);
    Optional<Token> findByUser(Usuarios user);
    void deleteByToken(String token);
}
