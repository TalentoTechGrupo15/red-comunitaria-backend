package com.redcomunitaria.talentotech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sexo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sexo {
    @Id
    @Column(name= "id_sexo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSexo;

    @Column(nullable = false, unique = true)
    private String nombre;
}
