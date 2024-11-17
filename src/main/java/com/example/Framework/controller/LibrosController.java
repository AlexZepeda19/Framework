package com.example.Framework.controller;

import com.example.Framework.entity.Libros;
import com.example.Framework.service.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/libros")
public class LibrosController {

    @Autowired
    private LibrosService librosService;

    // Obtener todos los libros
    @GetMapping
    public List<Libros> getAllLibros() {
        return librosService.getLibros();
    }

    // Obtener un libro por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Libros> getLibroById(@PathVariable("id") Long id) {
        Optional<Libros> libro = librosService.getLibros(id);
        return libro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear o actualizar un libro
    @PostMapping
    public ResponseEntity<Libros> saveOrUpdateLibro(@RequestBody Libros libro) {
        librosService.saveOrUpdate(libro);
        return new ResponseEntity<>(libro, HttpStatus.CREATED);
    }

    // Eliminar un libro por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable("id") Long id) {
        librosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
