package com.redcomunitaria.talentotech.controller;

import com.redcomunitaria.talentotech.service.TipoEmprendimientoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipo_emprendimiento")
public class TipoEmprendimientoController {

    private final TipoEmprendimientoService tipoEmprendimientoService;

    public TipoEmprendimientoController(TipoEmprendimientoService tipoEmprendimientoService) {
        this.tipoEmprendimientoService = tipoEmprendimientoService;
    }
}
