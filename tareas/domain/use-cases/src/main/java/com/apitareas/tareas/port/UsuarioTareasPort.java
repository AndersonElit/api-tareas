package com.apitareas.tareas.port;

import com.apitareas.tareas.request.UsuarioTareasRequest;

public interface UsuarioTareasPort {
    void guardarTarea(UsuarioTareasRequest request);
}
