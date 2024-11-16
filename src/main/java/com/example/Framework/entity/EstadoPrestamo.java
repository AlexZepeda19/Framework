package com.example.Framework.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EstadoPrestamo")
public class EstadoPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    @Column(name = "nombre_estado", nullable = false, length = 50)
    private String nombre_estado;

}
