package com.example.Framework.service;

import com.example.Framework.entity.EstadoPrestamo;
import com.example.Framework.repository.EstadoPrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EstadoPrestamoService {
    @Autowired
    private EstadoPrestamoRepository estadoPrestamoRepository;

    // Obtener todas las categorías
    public List<EstadoPrestamo> getEstadoPrestamo() {
        return estadoPrestamoRepository.findAll();
    }

    // Obtener una categoría por su ID
    public Optional<EstadoPrestamo> getEstadoPrestamo(Long id) {
        return estadoPrestamoRepository.findById(id);
    }

    // Guardar o actualizar una categoría
    public void saveOrUpdate(EstadoPrestamo estadoPrestamo) {
        estadoPrestamoRepository.save(estadoPrestamo);
    }

    // Eliminar una categoría por su ID
    public void deleteById(Long id) {
        estadoPrestamoRepository.deleteById(id);
    }
}
