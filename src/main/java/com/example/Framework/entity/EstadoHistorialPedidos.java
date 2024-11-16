package com.example.Framework.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EstadoHistorialPedidos")
public class EstadoHistorialPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estado; // Usar Long para el id

    @Column(name = "nombre_estado", nullable = false, length = 50)
    private String nombre_estado;
}
