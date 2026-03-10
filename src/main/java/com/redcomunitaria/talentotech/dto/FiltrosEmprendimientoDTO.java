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
public class FiltrosEmprendimientoDTO {
    private String nombre;
    private Integer tipo;
    private Integer pais;
    private String agruparPor;
    private Integer numeroResultados;
}
