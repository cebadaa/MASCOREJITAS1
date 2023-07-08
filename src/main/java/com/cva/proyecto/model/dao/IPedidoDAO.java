package com.cva.proyecto.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cva.proyecto.model.entidad.Pedido;

public interface IPedidoDAO extends CrudRepository<Pedido,Long>{
        public List<Pedido> findAllByOrderByFechaAsc();

}
