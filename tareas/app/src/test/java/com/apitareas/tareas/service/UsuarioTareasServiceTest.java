package com.apitareas.tareas.service;

import com.apitareas.tareas.model.Tarea;
import com.apitareas.tareas.model.UsuarioTareasId;
import com.apitareas.tareas.port.UsuarioTareasPort;
import com.apitareas.tareas.request.UsuarioTareasRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioTareasServiceTest {

    @Mock
    private UsuarioTareasPort port;

    @Autowired
    @InjectMocks
    private UsuarioTareasService service;

    UsuarioTareasRequest request;

    @BeforeEach
    void setUp() {
        request = UsuarioTareasRequest.builder()
                .id(UsuarioTareasId.builder()
                        .idUsuario(1)
                        .tarea(Tarea.builder()
                                .id(1)
                                .tarea("Administracion")
                                .build())
                        .build())
                .fechaInicio(LocalDateTime.now())
                .fechaFin(LocalDateTime.now())
                .build();
    }

    @Test
    void guardarTarea() {
        doNothing().when(port).guardarTarea(any(UsuarioTareasRequest.class));
        service.guardarTarea(request);
        verify(port, times(1)).guardarTarea(request);
    }
}