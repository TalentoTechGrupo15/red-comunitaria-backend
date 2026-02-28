package com.redcomunitaria.talentotech.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Long idEquipo;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;


    @OneToOne(mappedBy = "equipo")
    private Emprendimiento emprendimiento;

//    @JsonIgnore
//    @OneToMany(mappedBy = "equipo")
//    private List<Usuario> usuarios;





}
