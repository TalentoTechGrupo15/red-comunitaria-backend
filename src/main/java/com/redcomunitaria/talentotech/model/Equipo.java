package com.redcomunitaria.talentotech.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipo;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;


    @OneToOne
    @JoinColumn(name = "idEmprendimiento", nullable = false)
    private Emprendimiento emprendimiento;

    @JsonIgnore
    @OneToMany(mappedBy = "equipo")
    private List<Usuario> usuarios;





}
