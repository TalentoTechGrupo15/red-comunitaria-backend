package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.model.TipoEmprendimiento;
import com.redcomunitaria.talentotech.repository.TipoEmprendimientoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class TipoEmprendimientoService {

    private final TipoEmprendimientoRepository tipoEmprendimientoRepository;

    public TipoEmprendimiento buscarTipoEmprendimientoPorId(Long idTipoEmprendimiento){
        return tipoEmprendimientoRepository.findById(idTipoEmprendimiento)
                .orElseThrow(() -> new RuntimeException("Tipo de emprendimiento no encontrado"));
    }
}
