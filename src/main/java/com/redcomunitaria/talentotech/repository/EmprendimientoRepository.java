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
    JOIN e.region r
    JOIN r.pais p
    WHERE
        (:nombre IS NULL OR LOWER(e.nombre) LIKE CONCAT('%', LOWER(:nombre), '%'))
        AND (:tipo IS NULL OR te.idTipoEmprendimiento = :tipo)
        AND (:pais IS NULL OR r.idRegion = :pais)
    GROUP BY
        CASE
            WHEN :agruparPor = 'pais' THEN p.idPais
            WHEN :agruparPor = 'region' THEN r.idRegion
            ELSE e.idEmprendimiento
        END

   """)
    List<Emprendimiento> buscarConFiltros(@Param("nombre") String nombre,
                                         @Param("tipo") Integer tipo,
                                         @Param("pais") Integer pais,
                                         @Param("agruparPor") String agruparPor);
}
