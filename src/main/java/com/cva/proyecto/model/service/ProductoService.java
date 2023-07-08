package com.cva.proyecto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cva.proyecto.model.dao.IProductoDAO;
import com.cva.proyecto.model.entidad.Producto;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public void guardarProducto(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoDAO.deleteById(id);
    }

    @Override
    public List<Producto> mostrarProductos() {
        return (List<Producto>)productoDAO.findAll();
    }

    @Override
    public List<Producto> mostrarProOrdenAsc() {
        return productoDAO.findAllByOrderByNombreAsc();
    }

    @Override
    public Producto buscarProducto(Long id) {
        return productoDAO.findById(id).orElse(null);
    }
    
}
