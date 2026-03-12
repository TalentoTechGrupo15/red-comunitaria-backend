package com.redcomunitaria.talentotech.repository;

import com.redcomunitaria.talentotech.model.Emprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprendimientoRepository extends JpaRepository<Emprendimiento, Long> {

    @Query("""
    SELECT e
    FROM Emprendimiento e
    JOIN e.tipoEmprendimiento te
    JOIN e.etapa et
    JOIN e.region r
    JOIN r.pais p
    WHERE
        (:nombre IS NULL OR LOWER(e.nombre) LIKE CONCAT('%', LOWER(:nombre), '%'))
        AND (:tipo IS NULL OR te.idTipoEmprendimiento = :tipo)
        AND (:etapa IS NULL OR et.idEtapa = :etapa)
        AND (:pais IS NULL OR p.idPais = :pais)
   """)
    List<Emprendimiento> buscarConFiltros(@Param("nombre") String nombre,
                                         @Param("tipo") Integer tipo,
                                         @Param("etapa") Integer etapa,
                                         @Param("pais") Integer pais);
}
