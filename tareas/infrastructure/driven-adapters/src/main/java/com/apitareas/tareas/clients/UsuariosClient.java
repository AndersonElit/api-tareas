package com.apitareas.tareas.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${client.post.name}",
        url = "${client.post.baseUrl}")
public interface UsuariosClient {

    @GetMapping("/usuario-existe/{id}")
    ResponseEntity<Boolean> usuarioExiste(@PathVariable("id") Integer id);

}
