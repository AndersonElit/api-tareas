package com.apitareas.tareas.gateways;

import com.apitareas.tareas.model.Tarea;

public interface TareaRepository {
    Tarea guardarTarea(Tarea tarea);
}
