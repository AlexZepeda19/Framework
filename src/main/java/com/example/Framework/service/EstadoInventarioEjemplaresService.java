package com.example.Framework.service;

import com.example.Framework.entity.EstadoInventarioEjemplares;
import com.example.Framework.repository.EstadoInventarioEjemplaresRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EstadoInventarioEjemplaresService {
    @Autowired
    private EstadoInventarioEjemplaresRepository estadoInventarioEjemplaresRepository;

    public List<EstadoInventarioEjemplares> getEstadoInventarioEjemplares() {
        return estadoInventarioEjemplaresRepository.findAll();
    }

    public Optional<EstadoInventarioEjemplares> getEstadoInventarioEjemplares(Long id) {
        return estadoInventarioEjemplaresRepository.findById(id);
    }

    public void saveOrUpdate(EstadoInventarioEjemplares estadoInventarioEjemplares) {
        estadoInventarioEjemplaresRepository.save(estadoInventarioEjemplares);
    }

    public void deleteById(Long id) {
        estadoInventarioEjemplaresRepository.deleteById(id);
    }

}
