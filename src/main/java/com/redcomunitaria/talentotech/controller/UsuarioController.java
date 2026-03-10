package com.redcomunitaria.talentotech.controller;

import com.redcomunitaria.talentotech.dto.LoginRequestDTO;
import com.redcomunitaria.talentotech.dto.LoginResponseDTO;
import com.redcomunitaria.talentotech.dto.UsuarioDTO;
import com.redcomunitaria.talentotech.dto.EquipoDTO;
import com.redcomunitaria.talentotech.model.Equipo;
import com.redcomunitaria.talentotech.model.Usuario;
import com.redcomunitaria.talentotech.service.UsuarioService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.iniciarSesion(loginRequestDTO));
    }

    @PostMapping("/registro")
    public ResponseEntity<LoginResponseDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        LoginResponseDTO us = usuarioService.crearUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(us);
    }

    @PostMapping("crear_equipo")
    public ResponseEntity<Equipo> crearEquipo(@RequestBody EquipoDTO equipoDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.crearEquipo(equipoDTO));

    }
}
