package com.example.Framework.service;


import com.example.Framework.entity.HistorialPedidos;
import com.example.Framework.repository.HistorialPedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class HistorialPedidosService {

    @Autowired
    private HistorialPedidosRepository historialPedidosRepository;

    // Obtener todas las categorías
    public List<HistorialPedidos> getHistorialPedidos() {
        return historialPedidosRepository.findAll();
    }

    // Obtener una categoría por su ID
    public Optional<HistorialPedidos> getHistorialPedidos(Long id) {
        return historialPedidosRepository.findById(id);
    }

    // Guardar o actualizar una categoría
    public void saveOrUpdate(HistorialPedidos historialPedidos) {
        historialPedidosRepository.save(historialPedidos);
    }

    // Eliminar una categoría por su ID
    public void deleteById(Long id) {
        historialPedidosRepository.deleteById(id);
    }
}
