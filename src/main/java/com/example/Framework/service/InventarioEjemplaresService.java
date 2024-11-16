package com.example.Framework.service;

import com.example.Framework.entity.InventarioEjemplares;
import com.example.Framework.repository.InventarioEjemplaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioEjemplaresService {
    @Autowired
    private InventarioEjemplaresRepository inventarioEjemplaresRepository ;

    public List<InventarioEjemplares> getInventarioEjemplares() {
        return inventarioEjemplaresRepository.findAll();
    }

    public Optional<InventarioEjemplares> getInventarioEjemplares(Long id) {
        return inventarioEjemplaresRepository.findById(id);
    }

    public void saveOrUpdate(InventarioEjemplares inventarioEjemplares) {
        inventarioEjemplaresRepository.save(inventarioEjemplares);
    }

    public void deleteById(Long id) {
        inventarioEjemplaresRepository.deleteById(id);
    }
}

