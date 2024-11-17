package com.example.Framework.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estado;

    @Column(name = "nombre_estado", nullable = false, length = 50)
    private String nombreEstado;
}
