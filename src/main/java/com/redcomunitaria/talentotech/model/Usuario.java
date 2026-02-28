package com.redcomunitaria.talentotech.model;


import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private Integer cedula;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private Integer edad;

    @Column(nullable = false)
    private String sexo;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String clave;


    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

}
