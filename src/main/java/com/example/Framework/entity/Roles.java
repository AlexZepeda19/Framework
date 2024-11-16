package com.example.Framework.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Roles")

public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @Column(name = "nombre", nullable = false)
    private String nombre;
}
