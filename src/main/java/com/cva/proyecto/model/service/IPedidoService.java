package com.cva.proyecto.model.service;

import java.util.List;

import com.cva.proyecto.model.entidad.Pedido;

public interface IPedidoService {
    public void guardarPedido(Pedido pedido);
    public List<Pedido> mostrarPedidos();
    public void eliminarPedido(Long id);
    public List<Pedido> mostrarPeOrdenAsc();
    public Pedido buscarPedido(Long id);
}
