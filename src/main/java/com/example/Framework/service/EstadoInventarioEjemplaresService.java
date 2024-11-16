package com.example.Framework.service;

import com.example.Framework.entity.EstadoInventarioEjemplares;
import com.example.Framework.repository.EstadoInventarioEjemplaresRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EstadoInventarioEjemplaresService {
    @Autowired
    private EstadoInventarioEjemplaresRepository estadoInventarioEjemplaresRepository;

    // Obtener todas las categorías
    public List<EstadoInventarioEjemplares> getEstadoInventarioEjemplares() {
        return estadoInventarioEjemplaresRepository.findAll();
    }

    // Obtener una categoría por su ID
    public Optional<EstadoInventarioEjemplares> getEstadoInventarioEjemplares(Long id) {
        return estadoInventarioEjemplaresRepository.findById(id);
    }

    // Guardar o actualizar una categoría
    public void saveOrUpdate(EstadoInventarioEjemplares estadoInventarioEjemplares) {
        estadoInventarioEjemplaresRepository.save(estadoInventarioEjemplares);
    }

    // Eliminar una categoría por su ID
    public void deleteById(Long id) {
        estadoInventarioEjemplaresRepository.deleteById(id);
    }

}
