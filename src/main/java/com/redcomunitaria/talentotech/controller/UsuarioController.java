package com.redcomunitaria.talentotech.controller;

import com.redcomunitaria.talentotech.dto.UsuarioDTO;
import com.redcomunitaria.talentotech.dto.EquipoDTO;
import com.redcomunitaria.talentotech.model.Equipo;
import com.redcomunitaria.talentotech.model.Usuario;
import com.redcomunitaria.talentotech.service.UsuarioService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping("/registro")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario us = usuarioService.crearUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(us);
    }

    @PostMapping("crear_equipo")
    public ResponseEntity<Equipo> crearEquipo(@RequestBody EquipoDTO equipoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearEquipo(equipoDTO));

    }
}
