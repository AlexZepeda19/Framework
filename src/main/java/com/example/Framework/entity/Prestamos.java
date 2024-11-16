package com.example.Framework.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.security.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "Prestamos")
public class Prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prestamo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro")
    private Libros libro;

    @Column(name = "fecha_prestamo")
    private Timestamp fecha_prestamo;

    @Column(name = "fecha_devolucion")
    private Date fecha_devolucion;

    @ManyToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    private EstadoPrestamo estado;
}
