package com.cva.proyecto.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.cva.proyecto.model.entidad.Compras;

public interface IComprasDAO extends CrudRepository<Compras, Long>{
    
}
