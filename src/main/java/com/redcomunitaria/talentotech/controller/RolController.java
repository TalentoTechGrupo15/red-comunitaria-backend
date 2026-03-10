package com.redcomunitaria.talentotech.controller;

import com.redcomunitaria.talentotech.dto.RespuestaListaDTO;
import com.redcomunitaria.talentotech.service.RolService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rol")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class RolController {

    private final RolService rolService;

    @GetMapping("listar")
    public ResponseEntity<List<RespuestaListaDTO>> listar(){
        return ResponseEntity.ok(rolService.obtenerRoles());
    }
}
