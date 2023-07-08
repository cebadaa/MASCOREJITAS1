package com.cva.proyecto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cva.proyecto.model.dao.IPedidoDAO;
import com.cva.proyecto.model.entidad.Pedido;

@Service
public class PedidoServiceImp implements IPedidoService{
    @Autowired
    private IPedidoDAO pedidoDAO;

    @Override
    public void guardarPedido(Pedido pedido) {
        pedidoDAO.save(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoDAO.deleteById(id);
    }

    @Override
    public List<Pedido> mostrarPedidos() {
        return (List<Pedido>)pedidoDAO.findAll();     
    }

    @Override
    public List<Pedido> mostrarPeOrdenAsc() {
        return pedidoDAO.findAllByOrderByFechaAsc();
    }

    @Override
    public Pedido buscarPedido(Long id) {
        return pedidoDAO.findById(id).orElse(null);
    }
    
}
