package com.redcomunitaria.talentotech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
	private String nombre;
	private String apellido;
	private Integer cedula;
	private String correo;
	private Integer edad;
	private Long sexo;
	private String usuario;
	private String clave;
}
