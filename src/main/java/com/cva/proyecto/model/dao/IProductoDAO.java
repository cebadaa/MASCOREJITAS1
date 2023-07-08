package com.cva.proyecto.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cva.proyecto.model.entidad.Producto;

public interface IProductoDAO extends CrudRepository<Producto,Long> {
        public List<Producto> findAllByOrderByNombreAsc();
}
