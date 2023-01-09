package com.apitareas.tareas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioTareas {
    private UsuarioTareasId id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
}
