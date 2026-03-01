package com.redcomunitaria.talentotech.service;

import com.redcomunitaria.talentotech.repository.EmprendimientoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmprendimientoService {

    private final EmprendimientoRepository emprendimientoRepository;

    public EmprendimientoService(EmprendimientoRepository emprendimientoRepository) {
        this.emprendimientoRepository = emprendimientoRepository;
    }
}
