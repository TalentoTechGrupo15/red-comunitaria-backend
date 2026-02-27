package com.redcomunitaria.talentotech.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegion;

    @Column(nullable = false, unique = true)
    private String nombre;


    @ManyToOne
    @JoinColumn(name = "idPais", nullable = false)
    private Pais pais;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Emprendimiento> emprendimientos;




}
