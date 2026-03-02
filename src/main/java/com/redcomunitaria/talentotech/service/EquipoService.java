package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.dto.EquipoDTO;
import com.redcomunitaria.talentotech.model.Equipo;
import com.redcomunitaria.talentotech.repository.EquipoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class EquipoService {

    private final EquipoRepository equipoRepository;


    public Equipo crearEquipo(Equipo nuevoEquipo){

        return equipoRepository.save(nuevoEquipo);
    }


}
