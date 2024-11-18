package com.example.Framework.service;

import com.example.Framework.entity.Libros;
import com.example.Framework.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrosService {

    @Autowired
    private LibrosRepository librosRepository;

    // Obtener todos los libros
    public List<Libros> getLibros() {
        return librosRepository.findAll();
    }

    // Obtener un libro por su ID
    public Optional<Libros> getLibros(Long id) {
        return librosRepository.findById(id);
    }

    // Crear o actualizar un libro
    public Libros saveOrUpdate(Libros libro) {
        // Si el libro ya tiene un id (es decir, es una actualización), se guarda/actualiza
        // Si no tiene id (es decir, es una creación), se asigna un nuevo id automáticamente
        return librosRepository.save(libro);
    }

    // Eliminar un libro por su ID
    public void deleteById(Long id) {
        librosRepository.deleteById(id);
    }
}
