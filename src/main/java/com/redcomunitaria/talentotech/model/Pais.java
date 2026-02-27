package com.redcomunitaria.talentotech.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    @Column(nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
    private List<Region> regiones;

}
