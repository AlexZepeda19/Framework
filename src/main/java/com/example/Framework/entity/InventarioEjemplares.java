package com.example.Framework.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "InventarioEjemplares")
public class InventarioEjemplares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ejemplar;

    @ManyToOne
    @JoinColumn(name = "id_libro", referencedColumnName = "id_libro")
    private Libros libro;

    @ManyToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    private Estado estado;
}
