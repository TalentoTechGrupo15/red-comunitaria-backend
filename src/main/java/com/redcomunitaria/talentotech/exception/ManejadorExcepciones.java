package com.redcomunitaria.talentotech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejadorExcepciones {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntime(RuntimeException ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    @ExceptionHandler(UsuarioYaExisteExcepcion.class)
    public ResponseEntity<String> handleUsuarioYaExiste(UsuarioYaExisteExcepcion ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    @ExceptionHandler(CorreoYaExisteExcepcion.class)
    public ResponseEntity<String> handleCorreoYaExiste(CorreoYaExisteExcepcion ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

    @ExceptionHandler(CedulaYaExisteExcepcion.class)
    public ResponseEntity<String> handleCedulaYaExiste(CedulaYaExisteExcepcion ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }

}
