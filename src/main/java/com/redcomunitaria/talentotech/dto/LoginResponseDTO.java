package com.redcomunitaria.talentotech.dto;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponseDTO {
    private String usuario;
    private Long idEmprendimiento;
    private Long idEquipo;
    private String token;
}
