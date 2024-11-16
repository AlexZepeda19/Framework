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
    private LibrosRepository librosRepository ;

    public List<Libros> getLibros() {
        return librosRepository.findAll();
    }

    public Optional<Libros> getLibros(Long id) {
        return librosRepository.findById(id);
    }

    public void saveOrUpdate(Libros libros) {
        librosRepository.save(libros);
    }

    public void deleteById(Long id) {
        librosRepository.deleteById(id);
    }
}
