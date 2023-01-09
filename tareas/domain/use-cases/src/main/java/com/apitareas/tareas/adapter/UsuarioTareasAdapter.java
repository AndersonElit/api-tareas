package com.apitareas.tareas.adapter;

import com.apitareas.tareas.gateways.TareaRepository;
import com.apitareas.tareas.gateways.UsuarioTareasRepository;
import com.apitareas.tareas.gateways.UsuariosRepository;
import com.apitareas.tareas.model.Tarea;
import com.apitareas.tareas.model.UsuarioTareas;
import com.apitareas.tareas.model.UsuarioTareasId;
import com.apitareas.tareas.port.UsuarioTareasPort;
import com.apitareas.tareas.request.UsuarioTareasRequest;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@RequiredArgsConstructor
public class UsuarioTareasAdapter implements UsuarioTareasPort {

    private final UsuarioTareasRepository usuarioTareasRepository;
    private final TareaRepository tareaRepository;
    private final UsuariosRepository usuariosRepository;

    @Override
    public void guardarTarea(UsuarioTareasRequest request) {

        if (usuariosRepository
                .usuarioExiste(request.getId().getIdUsuario())) {

            Tarea tarea = new Tarea();
            if(Objects.isNull(request.getId().getTarea().getId())) {
                tarea = tareaRepository.guardarTarea(Tarea.builder()
                        .tarea(request.getId().getTarea().getTarea())
                        .build());
            }
            this.usuarioTareasRepository.guardarTarea(UsuarioTareas.builder()
                    .id(UsuarioTareasId.builder()
                            .idUsuario(request.getId().getIdUsuario())
                            .tarea(Tarea.builder()
                                    .id(tarea.getId() != null ? tarea.getId() : request.getId().getTarea().getId())
                                    .tarea(request.getId().getTarea().getTarea())
                                    .build())
                            .build())
                    .fechaInicio(LocalDateTime.now())
                    .build());

        } else {
            throw new IllegalArgumentException("El usuario no existe.");
        }
    }
}
