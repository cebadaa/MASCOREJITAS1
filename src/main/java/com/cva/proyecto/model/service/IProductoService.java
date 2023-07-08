package com.cva.proyecto.model.service;

import java.util.List;

import com.cva.proyecto.model.entidad.Producto;

public interface IProductoService {
    public void guardarProducto(Producto producto);
    public List<Producto> mostrarProductos();
    public void eliminarProducto(Long id);
    public List<Producto> mostrarProOrdenAsc();
    public Producto buscarProducto(Long id);
}
