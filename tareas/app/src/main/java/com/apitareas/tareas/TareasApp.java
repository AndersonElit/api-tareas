package com.apitareas.tareas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TareasApp {
    public static void main(String[] args) {
        SpringApplication.run(TareasApp.class, args);
    }
}
