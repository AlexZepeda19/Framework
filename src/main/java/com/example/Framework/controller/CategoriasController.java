package com.example.Framework.controller;

import com.example.Framework.entity.Categorias;
import com.example.Framework.service.CategoriasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categoria")
public class CategoriasController {
    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public List<Categorias> getAll() {
        return categoriasService.getCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> getCategorias(@PathVariable("id") Long idCategoria) {
        return categoriasService.getCategorias(idCategoria)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<Categorias> saveOrUpdate(@RequestBody Categorias categorias) {
        Categorias savedCategoria = categoriasService.saveOrUpdate(categorias);
        return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable("id") Long idCategoria) {
        categoriasService.deleteById(idCategoria);
        return ResponseEntity.noContent().build();
    }
}
