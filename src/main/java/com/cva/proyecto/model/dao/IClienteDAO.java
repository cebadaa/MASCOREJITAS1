package com.cva.proyecto.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cva.proyecto.model.entidad.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente,Long>{
        public List<Cliente> findAllByOrderByNombreAsc();

}
