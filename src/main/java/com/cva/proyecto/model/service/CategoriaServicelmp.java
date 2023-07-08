package com.cva.proyecto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cva.proyecto.model.dao.ICategoriaDAO;
import com.cva.proyecto.model.entidad.Categoria;

@Service
public class CategoriaServicelmp implements ICategoriaService {
    
    @Autowired
    private ICategoriaDAO categoriaDAO;

    @Override
    public void guardarCategoria(Categoria categoria) {
        categoriaDAO.save(categoria);
    }

    @Override
    public List<Categoria> mostrarCategorias() {
       return (List<Categoria>)categoriaDAO.findAll();     
    }

    @Override
    public Categoria buscarCategoria(Long id) {
        return categoriaDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaDAO.deleteById(id);
    }

    @Override
    public List<Categoria> mostrarCatOrdenAsc() {
        return categoriaDAO.findAllByOrderByNombreAsc();
    }

    @Override
    public List<Categoria> mostrarLike(String param1) {
        return categoriaDAO.cualquiernombre(param1);
    }
    
}