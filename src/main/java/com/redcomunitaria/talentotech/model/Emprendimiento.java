package com.redcomunitaria.talentotech.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "empredimiento")
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "idEtapa", nullable = false)
    private Etapa idEtapa;


    @ManyToOne
    @JoinColumn(name = "idRegion", nullable = false)
    private Region region;


    @ManyToOne
    @JoinColumn(name = "idTipoEmprendimiento", nullable = false)
    private TipoEmprendimiento tipoEmprendimiento;

    @OneToOne(mappedBy = "emprendimiento")
    private Equipo equipo;


}
