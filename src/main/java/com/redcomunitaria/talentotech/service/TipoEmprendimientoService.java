package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.repository.TipoEmprendimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoEmprendimientoService {

    private final TipoEmprendimientoRepository tipoEmprendimientoRepository;

    public TipoEmprendimientoService(TipoEmprendimientoRepository tipoEmprendimientoRepository) {
        this.tipoEmprendimientoRepository = tipoEmprendimientoRepository;
    }
}
