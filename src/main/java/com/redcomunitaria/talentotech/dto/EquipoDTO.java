package com.redcomunitaria.talentotech.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquipoDTO{
    private String nombre;
    private String descripcion;
    private List<String> integrantes;
}
