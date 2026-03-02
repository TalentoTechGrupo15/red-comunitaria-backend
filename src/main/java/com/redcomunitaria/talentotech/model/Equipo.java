package com.redcomunitaria.talentotech.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "equipo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Long idEquipo;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @OneToOne(mappedBy = "equipo", optional = true)
    private Emprendimiento emprendimiento;

//    @JsonIgnore
//    @OneToMany(mappedBy = "equipo")
//    private List<Usuario> usuarios;





}
