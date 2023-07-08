package com.cva.proyecto.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.cva.proyecto.model.entidad.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
}
