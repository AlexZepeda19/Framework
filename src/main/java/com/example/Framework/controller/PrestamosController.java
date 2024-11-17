package com.example.Framework.controller;

import com.example.Framework.entity.Prestamos;
import com.example.Framework.service.PrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/prestamos")
public class PrestamosController {

    @Autowired
    private PrestamosService prestamosService;

    // Obtener todos los préstamos
    @GetMapping
    public List<Prestamos> getAllPrestamos() {
        return prestamosService.getPrestamos();
    }

    // Obtener un préstamo por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Prestamos> getPrestamoById(@PathVariable("id") Long id) {
        Optional<Prestamos> prestamo = prestamosService.getPrestamos(id);
        return prestamo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear o actualizar un préstamo
    @PostMapping
    public ResponseEntity<Prestamos> saveOrUpdatePrestamo(@RequestBody Prestamos prestamo) {
        prestamosService.saveOrUpdate(prestamo);
        return new ResponseEntity<>(prestamo, HttpStatus.CREATED);
    }

    // Eliminar un préstamo por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable("id") Long id) {
        prestamosService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
