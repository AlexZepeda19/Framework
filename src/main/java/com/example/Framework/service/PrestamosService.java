package com.example.Framework.service;

import com.example.Framework.entity.Prestamos;
import com.example.Framework.repository.PrestamosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamosService {
    @Autowired
    private PrestamosRepository prestamosRepository ;

    public List<Prestamos> getPrestamos() {
        return prestamosRepository.findAll();
    }

    public Optional<Prestamos> getPrestamos(Long id) {
        return prestamosRepository.findById(id);
    }

    public void saveOrUpdate(Prestamos prestamos) {
        prestamosRepository.save(prestamos);
    }

    public void deleteById(Long id) {
        prestamosRepository.deleteById(id);
    }
}
