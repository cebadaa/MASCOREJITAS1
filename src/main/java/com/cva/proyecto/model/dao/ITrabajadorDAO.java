package com.cva.proyecto.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.cva.proyecto.model.entidad.Trabajador;

public interface ITrabajadorDAO extends CrudRepository<Trabajador,Long> {
    
}
