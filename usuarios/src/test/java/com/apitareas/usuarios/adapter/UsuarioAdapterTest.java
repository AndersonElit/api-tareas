package com.apitareas.usuarios.adapter;

import com.apitareas.usuarios.gateway.UsuarioRepository;
import com.apitareas.usuarios.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioAdapterTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioAdapter adapter;

    Usuario usuario;
    List<Usuario> listaUsuarios;

    @BeforeEach
    void setUp() {
        usuario = Usuario.builder()
                .id(1)
                .nombre("Andres")
                .cedula("12345")
                .build();
        listaUsuarios = List.of(Usuario.builder()
                .id(1)
                .nombre("Andres")
                .cedula("12345")
                .build());
    }

    @Test
    void guardarUsuario() {

    }

    @Test
    void listaUsuarios() {
        when(repository.listaUsuarios()).thenReturn(listaUsuarios);
        assertThat(adapter.listaUsuarios()).hasSize(listaUsuarios.size());
    }

    @Test
    void buscarUsuario() {
        when(repository.buscarUsuario(any(Integer.class))).thenReturn(usuario);
        assertThat(adapter.buscarUsuario(1)).isNotNull();
    }

    @Test
    void usuarioExiste() {
        when(repository.buscarUsuario(any(Integer.class))).thenReturn(usuario);
        assertThat(adapter.buscarUsuario(1)).isNotNull();
    }
}