package com.cva.proyecto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cva.proyecto.model.dao.IProductoDAO;
import com.cva.proyecto.model.entidad.Producto;

public class ProductoServicesImp implements IProductoService {
    @Autowired
    private IProductoDAO productoDao;

    @Override
    public void guardarProducto(Producto productos) {
        productoDao.save(productos);
    }

    @Override
    public List<Producto> mostrarProductos() {
        return(List<Producto>)productoDao.findAll();
    }
    
}
