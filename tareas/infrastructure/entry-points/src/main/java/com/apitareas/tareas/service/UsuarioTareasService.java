package com.apitareas.tareas.service;

import com.apitareas.tareas.port.UsuarioTareasPort;
import com.apitareas.tareas.request.UsuarioTareasRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class UsuarioTareasService {

    private final UsuarioTareasPort port;

    @Transactional(rollbackFor = { SQLException.class })
    public void guardarTarea(UsuarioTareasRequest request) {
        this.port.guardarTarea(request);
    }

}
