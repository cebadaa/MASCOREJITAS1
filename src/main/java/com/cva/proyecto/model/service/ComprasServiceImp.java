package com.cva.proyecto.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cva.proyecto.model.entidad.Compras;

@Service
public class ComprasServiceImp implements ICarroService {

    @Override
    public void agregarProducto(Long idProducto) {
        return ;
    }

    @Override
    public void eliminarProducto(Long idProducto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarProducto'");
    }

    @Override
    public void actualizarProducto(Long id_pro, int cantidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarProducto'");
    }

    @Override
    public void vaciarCarro() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vaciarCarro'");
    }

    @Override
    public List<Compras> mostrarCarrito() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarCarrito'");
    }

    @Override
    public double calcularTotal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularTotal'");
    }
    
}
