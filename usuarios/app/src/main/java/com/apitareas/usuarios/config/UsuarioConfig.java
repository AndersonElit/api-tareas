package com.apitareas.usuarios.config;

import com.apitareas.usuarios.adapter.UsuarioAdapter;
import com.apitareas.usuarios.gateway.UsuarioRepository;
import com.apitareas.usuarios.port.UsuarioPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public UsuarioPort usuarioPort(UsuarioRepository repository) {
        return new UsuarioAdapter(repository);
    }

}
