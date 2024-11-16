package com.example.Framework.service;

import com.example.Framework.entity.Token;
import com.example.Framework.entity.Usuarios;
import com.example.Framework.repository.TokenRepository;
import com.example.Framework.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private TokenRepository tokenRepository;

    public List<Usuarios> getUsuarios() {
        return usuariosRepository.findAll();
    }

    public Optional<Usuarios> getUsuarios(Long id) {
        return usuariosRepository.findById(id);
    }

    public Usuarios saveOrUpdate(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    public void deleteById(Long id) {
        usuariosRepository.deleteById(id);
    }

    public Optional<Usuarios> authenticateUser(String email, String password) {
        Optional<Usuarios> user = usuariosRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            LocalDateTime loginTime = LocalDateTime.now();
            Long userId = user.get().getId_usuario();
            Long roleId = user.get().getRol().getId_rol();
            String tokenString = loginTime.toString() + "-" + userId + "-" + roleId;
            Token token = new Token();
            token.setToken(tokenString);
            token.setCreationTime(loginTime);
            token.setUser(user.get());
            tokenRepository.save(token);
            return Optional.of(user.get());
        } else {
            return Optional.empty();
        }
    }

    public Token findTokenByUser(Usuarios user) {
        return tokenRepository.findByUser(user)
                .orElse(null);
    }

    public void clearExpiredTokens() {
        LocalDateTime now = LocalDateTime.now();
        List<Token> tokens = tokenRepository.findAll();
        for (Token token : tokens) {
            LocalDateTime tokenExpiryTime = token.getCreationTime().plusMinutes(5);
            if (now.isAfter(tokenExpiryTime)) {
                tokenRepository.delete(token);
            }
        }
    }

    public void logoutUser(String tokenString) {
        Optional<Token> tokenOptional = tokenRepository.findByToken(tokenString);
        if (tokenOptional.isPresent()) {
            tokenRepository.delete(tokenOptional.get());
            System.out.println("Token eliminado: " + tokenString);
        } else {
            System.out.println("Token no encontrado: " + tokenString);
        }
    }
}
