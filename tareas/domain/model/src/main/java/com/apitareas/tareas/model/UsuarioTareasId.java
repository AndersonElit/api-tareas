package com.apitareas.tareas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioTareasId {
    private Integer idUsuario;
    private Tarea tarea;
}
