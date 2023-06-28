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
    public List<Pedido> listarPedidos() {
        return pedidoDAO.findAllByOrderByFechaAsc();
    }

    @Override
    public String eliminarPedido(Long id) {
        String rpta = "";
        try{
            pedidoDAO.deleteById(id);
            rpta = "Se eliminó el pedido correctamente";
        }catch(Exception e ){
            rpta = e.getMessage();
        }
        return rpta;
    }
    
}
