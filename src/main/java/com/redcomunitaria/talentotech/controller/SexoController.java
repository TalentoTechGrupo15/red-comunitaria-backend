package com.redcomunitaria.talentotech.controller;


import com.redcomunitaria.talentotech.dto.RespuestaListaDTO;
import com.redcomunitaria.talentotech.model.Sexo;
import com.redcomunitaria.talentotech.service.SexoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sexo")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SexoController {

    private final SexoService sexoService;

    @GetMapping("/listar")
    public ResponseEntity<List<RespuestaListaDTO>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(sexoService.obtenerSexo());
    }
}
