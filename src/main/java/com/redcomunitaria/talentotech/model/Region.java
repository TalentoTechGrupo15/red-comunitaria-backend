package com.redcomunitaria.talentotech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "region")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    @Column(name= "id_region")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegion;

    @Column(nullable = false, unique = true)
    private String nombre;


    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;

//    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
//    private List<Emprendimiento> emprendimientos;




}
