package com.cva.proyecto.model.service;

import java.util.List;

import com.cva.proyecto.model.entidad.Cliente;

public interface IClienteService {
    public void guardarCliente(Cliente clientes);
    public Cliente buscarCliente(Long id);
    public List<Cliente> mostrarClientes();
    public void eliminarCliente(Cliente clientes);




}
