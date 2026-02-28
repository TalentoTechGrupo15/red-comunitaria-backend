package com.redcomunitaria.talentotech.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "empredimiento")
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_emprendimiento")
    private Long idEmprendimiento;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = true)
    private Date year;

    @Column(nullable = false)
    private Double inversion;



    @ManyToOne
    @JoinColumn(name = "id_etapa", nullable = false)
    private Etapa etapa;


    @ManyToOne
    @JoinColumn(name = "id_region", nullable = false)
    private Region region;


    @ManyToOne
    @JoinColumn(name = "id_tipo_emprendimiento", nullable = false)
    private TipoEmprendimiento tipoEmprendimiento;

    @OneToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;


}
