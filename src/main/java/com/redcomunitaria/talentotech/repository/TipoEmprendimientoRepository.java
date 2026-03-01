package com.redcomunitaria.talentotech.repository;

import com.redcomunitaria.talentotech.model.TipoEmprendimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEmprendimientoRepository extends JpaRepository<TipoEmprendimiento, Long> {
}
