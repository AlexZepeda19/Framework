package com.example.Framework.service;

import com.example.Framework.entity.EstadoReservas;
import com.example.Framework.repository.EstadoReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EstadoReservasService {
    @Autowired
    private EstadoReservasRepository estadoReservasRepository;

    public List<EstadoReservas> getEstadoReservas() {
        return estadoReservasRepository.findAll();
    }

    public Optional<EstadoReservas> getEstadoReservas(Long id) {
        return estadoReservasRepository.findById(id);
    }

    public void saveOrUpdate(EstadoReservas estadoReservas) {
        estadoReservasRepository.save(estadoReservas);
    }

    public void deleteById(Long id) {
        estadoReservasRepository.deleteById(id);
    }
}
