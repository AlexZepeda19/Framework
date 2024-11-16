package com.example.Framework.service;

import com.example.Framework.entity.EstadoReservas;
import com.example.Framework.repository.EstadoReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EstadoReservasService {
    @Autowired
    private EstadoReservasRepository estadoReservasRepository;

    // Obtener todas las categorías
    public List<EstadoReservas> getEstadoReservas() {
        return estadoReservasRepository.findAll();
    }

    // Obtener una categoría por su ID
    public Optional<EstadoReservas> getEstadoReservas(Long id) {
        return estadoReservasRepository.findById(id);
    }

    // Guardar o actualizar una categoría
    public void saveOrUpdate(EstadoReservas estadoReservas) {
        estadoReservasRepository.save(estadoReservas);
    }

    // Eliminar una categoría por su ID
    public void deleteById(Long id) {
        estadoReservasRepository.deleteById(id);
    }
}
