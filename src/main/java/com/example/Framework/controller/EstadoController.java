package com.example.Framework.controller;

import com.example.Framework.entity.Estado;
import com.example.Framework.service.EstadoService;  // Asegúrate de importar el servicio correcto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/estado")  // Ruta base para el controlador de Estado
public class EstadoController {

    private final EstadoService estadoService;

    // Inyección de dependencias para el servicio de Estado
    @Autowired
    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    // Obtener todos los estados
    @GetMapping
    public List<Estado> getAll() {
        return estadoService.getEstado();
    }

    // Obtener un estado por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Estado> getEstadoById(@PathVariable("id") Long estadoId) {
        Optional<Estado> estado = estadoService.getEstado(estadoId);
        if (estado.isPresent()) {
            return new ResponseEntity<>(estado.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear o actualizar un estado
    @PostMapping
    public ResponseEntity<Estado> saveOrUpdate(@RequestBody Estado estado) {
        Estado savedEstado = estadoService.saveOrUpdate(estado);
        return new ResponseEntity<>(savedEstado, HttpStatus.CREATED);  // Retorna el estado creado
    }

    // Eliminar un estado por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable("id") Long estadoId) {
        Optional<Estado> estado = estadoService.getEstado(estadoId);
        if (estado.isPresent()) {
            estadoService.deleteById(estadoId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Estado eliminado correctamente
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Estado no encontrado
        }
    }
}
