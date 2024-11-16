package com.example.Framework.service;

import com.example.Framework.entity.Roles;
import com.example.Framework.entity.Usuarios;
import com.example.Framework.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

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
}
