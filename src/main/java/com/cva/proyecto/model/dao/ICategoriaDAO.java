package com.cva.proyecto.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cva.proyecto.model.entidad.Categoria;

public interface ICategoriaDAO extends CrudRepository<Categoria,Long> {
    public List<Categoria> findAllByOrderByNombreAsc();
    
    @Query(value = "SELECT *FROM categorias WHERE cat_nombre like ?1",nativeQuery = true)
    public List<Categoria> cualquiernombre(String param1);
}
