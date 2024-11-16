package com.example.Framework.service;


import com.example.Framework.entity.Reservas;
import com.example.Framework.repository.ReservasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservasService {
    @Autowired
    private ReservasRepository reservasRepository ;

    public List<Reservas> getReservas() {
        return reservasRepository.findAll();
    }

    public Optional<Reservas> getReservas(Long id) {
        return reservasRepository.findById(id);
    }

    public void saveOrUpdate(Reservas reservas) {
        reservasRepository.save(reservas);
    }

    public void deleteById(Long id) {
        reservasRepository.deleteById(id);
    }
}
