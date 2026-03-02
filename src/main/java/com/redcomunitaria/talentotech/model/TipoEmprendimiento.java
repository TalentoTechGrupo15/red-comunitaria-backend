package com.redcomunitaria.talentotech.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_emprendimiento")
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
