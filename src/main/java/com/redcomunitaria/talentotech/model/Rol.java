package com.redcomunitaria.talentotech.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Column(nullable = false, unique = true)
    private String nombre;


    @JsonIgnore
    @OneToMany (mappedBy = "rol")
    private List<Usuario> usuarios;
}
