package com.example.Framework.controller;

import com.example.Framework.entity.Usuarios;
import com.example.Framework.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/usuario")
public class UsuariosController {

    private final UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<Usuarios> getAll() {
        return usuariosService.getUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuarios> getUser(@PathVariable("id") Long userId) {
        return usuariosService.getUsuarios(userId);
    }

    @PostMapping
    public ResponseEntity<Usuarios> saveOrUpdate(@RequestBody Usuarios usuarios) {
        Usuarios savedUsers = usuariosService.saveOrUpdate(usuarios);
        return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long userId) {
        usuariosService.deleteById(userId);
    }
}
