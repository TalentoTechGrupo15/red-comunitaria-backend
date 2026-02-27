package com.redcomunitaria.talentotech.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipo_empredimiento")
public class TipoEmprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoEmprendimiento;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @JsonIgnore
    @OneToMany(mappedBy = "tipoEmprendimiento", cascade = CascadeType.ALL)
    private List<Emprendimiento> emprendimientos;
}
