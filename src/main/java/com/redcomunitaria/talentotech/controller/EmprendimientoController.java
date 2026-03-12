package com.redcomunitaria.talentotech.controller;

import com.redcomunitaria.talentotech.dto.EmprendimientoDTO;
import com.redcomunitaria.talentotech.model.Emprendimiento;
import com.redcomunitaria.talentotech.service.EmprendimientoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprendimiento")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EmprendimientoController {

    private final EmprendimientoService emprendimientoService;


    @PostMapping("/crear_emprendimiento")
    public ResponseEntity<Emprendimiento> crearEmprendimiento(@RequestBody EmprendimientoDTO emprendimientoDTO){
        Emprendimiento emp = emprendimientoService.crearEmprendimiento(emprendimientoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(emp);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Emprendimiento>> buscar(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Integer tipo,
            @RequestParam(required = false) Integer pais,
            @RequestParam(required = false) Integer etapa,
            @RequestParam(required = false) String agruparPor,
            @RequestParam(required = false, defaultValue = "10") Integer numeroResultados){
        List<Emprendimiento> emp = emprendimientoService.buscarEmprendimiento(nombre, tipo, etapa, pais, agruparPor, numeroResultados);
        return ResponseEntity.status(HttpStatus.OK).body(emp);
    }


}
