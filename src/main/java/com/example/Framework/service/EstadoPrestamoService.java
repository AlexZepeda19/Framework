package com.example.Framework.service;

import com.example.Framework.entity.EstadoPrestamo;
import com.example.Framework.repository.EstadoPrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EstadoPrestamoService {
    @Autowired
    private EstadoPrestamoRepository estadoPrestamoRepository;

    public List<EstadoPrestamo> getEstadoPrestamo() {
        return estadoPrestamoRepository.findAll();
    }

    public Optional<EstadoPrestamo> getEstadoPrestamo(Long id) {
        return estadoPrestamoRepository.findById(id);
    }

    public void saveOrUpdate(EstadoPrestamo estadoPrestamo) {
        estadoPrestamoRepository.save(estadoPrestamo);
    }

    public void deleteById(Long id) {
        estadoPrestamoRepository.deleteById(id);
    }
}
