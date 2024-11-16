package com.example.Framework.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;  // Nombre del usuario

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;  // Email del usuario

    @Column(name = "password", nullable = false, length = 255)
    private String password;  // Contraseña del usuario

    @Column(name = "fecha_registro", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private String fechaRegistro;  // Fecha y hora en la que se registró el usuario

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", insertable = false, updatable = false)
    private Roles rol;  // Relación con la tabla Roles (Many to One)

}
