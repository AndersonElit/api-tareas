package com.apitareas.tareas.request;

import com.apitareas.tareas.model.UsuarioTareasId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioTareasRequest {
    private UsuarioTareasId id;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
}
