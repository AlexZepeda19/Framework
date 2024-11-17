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
    private ReservasRepository reservasRepository;

    // Obtener todas las reservas
    public List<Reservas> getAllReservas() {
        return reservasRepository.findAll();
    }

    // Obtener una reserva por su ID
    public Optional<Reservas> getReservaById(Long id) {
        return reservasRepository.findById(id);
    }

    // Guardar o actualizar una reserva (ahora separados)
    public Reservas createReserva(Reservas reserva) {
        return reservasRepository.save(reserva);
    }

    public Reservas updateReserva(Reservas reserva) {
        // Aquí podrías hacer más validaciones si es necesario, como verificar que la reserva existe
        return reservasRepository.save(reserva);
    }

    // Eliminar una reserva por su ID
    public void deleteReserva(Long id) {
        reservasRepository.deleteById(id);
    }
}
