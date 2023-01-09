package com.apitareas.tareas.controller;

import com.apitareas.tareas.request.UsuarioTareasRequest;
import com.apitareas.tareas.service.UsuarioTareasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tareas")
@RequiredArgsConstructor
public class UsuarioTareasController {

    private final UsuarioTareasService service;

    @PostMapping("/guardar")
    public ResponseEntity guardarTarea(
            @RequestBody UsuarioTareasRequest request) {
        try {
            this.service.guardarTarea(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("La tarea se registro con exito");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("no se pudo gradar la tarea");
        }
    }


}
