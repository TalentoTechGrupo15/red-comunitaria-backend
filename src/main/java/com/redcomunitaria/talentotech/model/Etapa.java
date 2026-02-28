package com.redcomunitaria.talentotech.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "etapa")
public class Etapa {

    @Id
    @Column(name = "id_etapa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtapa;

    @Column(nullable = false, unique = true)
    private String nombre;

//    @JsonIgnore
//    @OneToMany (mappedBy = "etapa", cascade = CascadeType.ALL)
//    private List<Emprendimiento> emprendimientos;
}
