package com.redcomunitaria.talentotech.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "emprendimiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @JsonManagedReference
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

    @Column
    private Double ingresos;

    @Column
    private Double empleados;

}
