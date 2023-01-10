package com.apitareas.tareas.controller;

import com.apitareas.tareas.model.Tarea;
import com.apitareas.tareas.model.UsuarioTareasId;
import com.apitareas.tareas.request.UsuarioTareasRequest;
import com.apitareas.tareas.service.UsuarioTareasService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioTareasController.class)
class UsuarioTareasControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    UsuarioTareasService service;

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
    void guardarTarea() throws Exception {
        mvc.perform(post("/api/v1/tareas/guardar").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andDo(print());
    }
}