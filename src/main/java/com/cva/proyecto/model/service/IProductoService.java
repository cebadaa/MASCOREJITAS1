package com.cva.proyecto.model.service;

import java.util.List;

import com.cva.proyecto.model.entidad.Producto;

public interface IProductoService {
    public void guardarProducto(Producto producto);
    public List<Producto> listarProductos();
    public String eliminarProducto(Long id);
}
