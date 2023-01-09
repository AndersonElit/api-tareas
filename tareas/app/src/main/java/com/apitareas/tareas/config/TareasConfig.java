package com.apitareas.tareas.config;

import com.apitareas.tareas.adapter.UsuarioTareasAdapter;
import com.apitareas.tareas.gateways.TareaRepository;
import com.apitareas.tareas.gateways.UsuarioTareasRepository;
import com.apitareas.tareas.gateways.UsuariosRepository;
import com.apitareas.tareas.port.UsuarioTareasPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TareasConfig {

    @Bean
    public UsuarioTareasPort port(UsuarioTareasRepository usuarioTareasRepository, TareaRepository tareaRepository, UsuariosRepository usuariosRepository) {
        return new UsuarioTareasAdapter(usuarioTareasRepository, tareaRepository, usuariosRepository);
    }
}
