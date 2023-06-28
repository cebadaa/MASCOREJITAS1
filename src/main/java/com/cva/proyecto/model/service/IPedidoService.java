package com.cva.proyecto.model.service;

import java.util.List;

import com.cva.proyecto.model.entidad.Pedido;

public interface IPedidoService {
    public void guardarPedido(Pedido pedido);
    public List<Pedido> listarPedidos();
    public String eliminarPedido(Long id);
}
