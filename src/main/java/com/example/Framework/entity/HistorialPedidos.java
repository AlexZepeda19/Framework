package com.example.Framework.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.security.Timestamp;

@Data
@Entity
@Table(name = "HistorialPedidos")
public class HistorialPedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_historial;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro")
    private Libros libro;

    @Column(name = "fecha_pedido")
    private Timestamp fecha_pedido;

    @ManyToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    private Estado estado;
}
