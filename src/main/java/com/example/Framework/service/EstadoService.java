package com.example.Framework.service;

import com.example.Framework.entity.Estado;  // Asegúrate de importar la entidad correcta
import com.example.Framework.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> getEstado() {
        return estadoRepository.findAll();
    }


    public Optional<Estado> getEstado(Long id) {
        return estadoRepository.findById(id);
    }


    public Estado saveOrUpdate(Estado estado) {
        return estadoRepository.save(estado);
    }


    public void deleteById(Long id) {
        estadoRepository.deleteById(id);
    }
}
