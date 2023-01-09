package com.apitareas.usuarios.controller;

import com.apitareas.usuarios.request.UsuarioRequest;
import com.apitareas.usuarios.response.UsuarioResponse;
import com.apitareas.usuarios.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping("/guardar")
    public ResponseEntity guardarUsuario(@RequestBody UsuarioRequest request) {
        try {
            this.service.guardarUsuario(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("El usuario se guardó de forma exitosa.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al guardar el usuario.");
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<List<UsuarioResponse>> listaUsuarios() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.listaUsuarios());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/buscar-usuario/{id}")
    public ResponseEntity<UsuarioResponse> buscarUsuario(@PathVariable("id") Integer id) {
        try {
            if(service.usuarioExiste(id)) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(service.buscarUsuario(id));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/usuario-existe/{id}")
    public ResponseEntity<Boolean> usuarioExiste(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.usuarioExiste(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

}
