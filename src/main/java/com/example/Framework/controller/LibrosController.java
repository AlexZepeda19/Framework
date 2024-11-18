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
    public ResponseEntity<Libros> createLibro(@RequestBody Libros libro) {
        // Si el libro ya tiene un id (en el caso de actualización), no debería ser un POST.
        // El POST se usa solo para la creación de un nuevo libro
        if (libro.getId_libro() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null); // Si ya tiene ID, el POST no es válido
        }
        librosService.saveOrUpdate(libro); // Crear un libro nuevo
        return new ResponseEntity<>(libro, HttpStatus.CREATED); // Retornar el libro creado con código HTTP 201
    }

    // Actualizar un libro existente
    @PutMapping("/{id}")
    public ResponseEntity<Libros> updateLibro(@PathVariable("id") Long id, @RequestBody Libros libro) {
        Optional<Libros> libroExistente = librosService.getLibros(id);

        if (libroExistente.isPresent()) {
            libro.setId_libro(id); // Asegurarse de que se mantenga el ID correcto
            librosService.saveOrUpdate(libro); // Actualiza el libro
            return ResponseEntity.ok(libro); // Devuelve el libro actualizado con código HTTP 200
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Si no existe el libro
        }
    }

    // Eliminar un libro por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable("id") Long id) {
        librosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
