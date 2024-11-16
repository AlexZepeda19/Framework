package com.example.Framework.service;

import com.example.Framework.repository.EstadoHistorialPedidosRepository;
import com.example.Framework.entity.EstadoHistorialPedidos;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EstadoHistorialPedidosService {

    @Autowired
    private EstadoHistorialPedidosRepository estadoHistorialPedidosRepository;

    // Obtener todas las categorías
    public List<EstadoHistorialPedidos> getEstadoHistorialPedidos() {
        return estadoHistorialPedidosRepository.findAll();
    }

    // Obtener una categoría por su ID
    public Optional<EstadoHistorialPedidos> getEstadoHistorialPedidos(Long id) {
        return estadoHistorialPedidosRepository.findById(id);
    }

    // Guardar o actualizar una categoría
    public void saveOrUpdate(EstadoHistorialPedidos estadoHistorialPedidos) {
        estadoHistorialPedidosRepository.save(estadoHistorialPedidos);
    }

    // Eliminar una categoría por su ID
    public void deleteById(Long id) {
        estadoHistorialPedidosRepository.deleteById(id);
    }
}
