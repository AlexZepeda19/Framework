package com.example.Framework.service;

import com.example.Framework.entity.Categorias;
import com.example.Framework.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    // Obtener todas las categorías
    public List<Categorias> getCategorias() {
        return categoriasRepository.findAll();
    }

    // Obtener una categoría por su ID
    public Optional<Categorias> getCategorias(Long id) {
        return categoriasRepository.findById(id);
    }

    // Guardar o actualizar una categoría
    public void saveOrUpdate(Categorias categorias) {
        categoriasRepository.save(categorias);
    }

    // Eliminar una categoría por su ID
    public void deleteById(Long id) {
        categoriasRepository.deleteById(id);
    }
}
