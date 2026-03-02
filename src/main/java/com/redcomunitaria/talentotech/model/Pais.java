package com.redcomunitaria.talentotech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pais")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
    @Id
    @Column(name = "id_pais")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    @Column(nullable = false, unique = true)
    private String nombre;

//    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)
//    private List<Region> regiones;

}
