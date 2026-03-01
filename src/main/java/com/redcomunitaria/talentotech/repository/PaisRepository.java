package com.redcomunitaria.talentotech.repository;

import com.redcomunitaria.talentotech.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}
