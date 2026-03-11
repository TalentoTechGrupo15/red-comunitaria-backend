package com.redcomunitaria.talentotech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmprendimientoDTO {
    private String nombre;
    private String descripcion;
    private Integer year;
    private Double inversion;
    private Long idEtapa;
    private Long idRegion;
    private Long idTipoEmprendimiento;
    private Long idEquipo;
}
