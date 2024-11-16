package com.example.Framework.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Libros")
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_libro;

    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "autor", nullable = false, length = 100)
    private String autor;

    @ManyToOne
    @JoinColumn(name = "categoria", referencedColumnName = "id_categoria")
    private Categorias categoria;

    @Column(name = "isbn", unique = true, length = 20)
    private String isbn;

    @Column(name = "editorial", length = 100)
    private String editorial;

    @Column(name = "fecha_publicacion")
    private Date fecha_publicacion;

    @Column(name = "cantidad_total", nullable = false)
    private int cantidad_total;

    @Column(name = "cantidad_disponible", nullable = false)
    private int cantidad_disponible;
}
