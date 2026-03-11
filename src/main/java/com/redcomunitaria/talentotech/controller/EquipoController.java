package com.redcomunitaria.talentotech.controller;

import com.redcomunitaria.talentotech.dto.EquipoDTO;
import com.redcomunitaria.talentotech.model.Equipo;
import com.redcomunitaria.talentotech.service.EquipoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipo")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipoController {

    private final EquipoService equipoService;

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Equipo> buscarEquipoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(equipoService.buscarEquipoPorId(id));
    }

}
