package com.redcomunitaria.talentotech.controller;

import com.redcomunitaria.talentotech.service.EmprendimientoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprendimiento")
public class EmprendimientoController {

    private final EmprendimientoService emprendimientoService;

    public EmprendimientoController(EmprendimientoService emprendimientoService) {
        this.emprendimientoService = emprendimientoService;
    }
}
