package com.redcomunitaria.talentotech.controller;

import com.redcomunitaria.talentotech.dto.RespuestaListaDTO;
import com.redcomunitaria.talentotech.service.PaisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pais")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaisController {

    private final PaisService paisService;

    @GetMapping("listar")
    public ResponseEntity<List<RespuestaListaDTO>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(paisService.obtenerPaises());
    }


}
