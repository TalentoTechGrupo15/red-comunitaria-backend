package com.redcomunitaria.talentotech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "emprendimiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_emprendimiento")
    private Long idEmprendimiento;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;


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
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;


}
