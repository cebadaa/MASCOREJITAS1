package com.cva.proyecto.model.service;

import java.util.List;

import com.cva.proyecto.model.entidad.Categoria;

public interface ICategoriaService {    
    public void guardarCategoria(Categoria categoria);
    //List ->java-util
    public List<Categoria> mostrarCategorias();
    public List<Categoria> mostrarCatOrdenAsc();
    public List<Categoria> mostrarLike(String param1);

    public Categoria buscarCategoria(Long id);
    public void eliminarCategoria(Long id);
}