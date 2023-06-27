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
    public List<Producto> listarProductos() {
        return productoDAO.findAllByOrderByNombreAsc();
    }

    @Override
    public String eliminarProducto(Long id) {
        String rpta = "";
        try{
            productoDAO.deleteById(id);
            rpta = "Se eliminó el producto correctamente";
        }catch(Exception e ){
            rpta = e.getMessage();
        }
        return rpta;
    }
    
}
