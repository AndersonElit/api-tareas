package com.apitareas.usuarios.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
    private Integer id;
    private String cedula;
    private String nombre;
    private LocalDate fechaCreacion;
}
