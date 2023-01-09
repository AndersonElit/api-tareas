package com.apitareas.usuarios.controller;

import com.apitareas.usuarios.request.UsuarioRequest;
import com.apitareas.usuarios.response.UsuarioResponse;
import com.apitareas.usuarios.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDate;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private UsuarioService service;
    @Autowired
    private ObjectMapper objectMapper;

    UsuarioRequest request;
    UsuarioResponse usuario;
    List<UsuarioResponse> listaUsuarios;

    @BeforeEach
    void setUp() {
        request = UsuarioRequest.builder()
                .nombre("Andres")
                .cedula("12345")
                .build();
        listaUsuarios = List.of(UsuarioResponse.builder()
                .id(1)
                .nombre("Andres")
                .cedula("12345")
                .fechaCreacion(LocalDate.now())
                .build());
    }

    @Test
    void guardarUsuario() throws Exception {
        mvc.perform(post("/api/v1/usuarios/guardar").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    void listaUsuarios() throws Exception {
        when(service.listaUsuarios()).thenReturn(listaUsuarios);
        mvc.perform(get("/api/v1/usuarios/lista"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(listaUsuarios.size()))
                .andDo(print());
    }

    @Test
    void buscarUsuario() throws Exception {
        Integer id = 1;
        when(service.buscarUsuario(id)).thenReturn(usuario);
        mvc.perform(get("/api/v1/usuarios/buscar-usuario/{id}", id))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void usuarioExiste() throws Exception {
        Integer id = 1;
        when(service.buscarUsuario(id)).thenReturn(usuario);
        mvc.perform(get("/api/v1/usuarios/usuario-existe/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}