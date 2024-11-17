package com.example.Framework.controller;

import com.example.Framework.entity.Reservas;
import com.example.Framework.service.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservasController {

    @Autowired
    private ReservasService reservasService;

    // Obtener todas las reservas
    @GetMapping
    public ResponseEntity<List<Reservas>> getAllReservas() {
        List<Reservas> reservas = reservasService.getAllReservas();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    // Obtener una reserva por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservas> getReservaById(@PathVariable("id") Long id) {
        Optional<Reservas> reserva = reservasService.getReservaById(id);
        return reserva.map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear una nueva reserva
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservas> createReserva(@RequestBody Reservas reserva) {
        Reservas nuevaReserva = reservasService.createReserva(reserva); // Llamar al servicio para guardar la reserva
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaReserva);
    }

    // Actualizar una reserva existente
    @PutMapping("/{id}")
    public ResponseEntity<Reservas> updateReserva(@PathVariable("id") Long id, @RequestBody Reservas reserva) {
        Optional<Reservas> existingReserva = reservasService.getReservaById(id);
        if (existingReserva.isPresent()) {
            reserva.setId_reserva(id);  // Actualizar el ID de la reserva
            Reservas updatedReserva = reservasService.updateReserva(reserva);
            return new ResponseEntity<>(updatedReserva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una reserva por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable("id") Long id) {
        Optional<Reservas> existingReserva = reservasService.getReservaById(id);
        if (existingReserva.isPresent()) {
            reservasService.deleteReserva(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
