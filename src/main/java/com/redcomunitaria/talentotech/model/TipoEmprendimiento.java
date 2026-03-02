package com.redcomunitaria.talentotech.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tipo_empredimiento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoEmprendimiento {

    @Id
    @Column(name = "id_tipo_emprendimiento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoEmprendimiento;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

//    @JsonIgnore
//    @OneToMany(mappedBy = "tipoEmprendimiento", cascade = CascadeType.ALL)
//    private List<Emprendimiento> emprendimientos;
}
