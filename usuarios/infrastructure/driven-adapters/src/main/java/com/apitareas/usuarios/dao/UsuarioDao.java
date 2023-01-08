package com.apitareas.usuarios.dao;

import com.apitareas.usuarios.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<UsuarioEntity, Integer> {
}
