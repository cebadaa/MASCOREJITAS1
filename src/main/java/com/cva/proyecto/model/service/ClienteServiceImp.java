package com.cva.proyecto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cva.proyecto.model.dao.IClienteDAO;
import com.cva.proyecto.model.entidad.Cliente;

@Service
public class ClienteServiceImp implements IClienteService {
    @Autowired 
    private IClienteDAO clientesDao;

    @Override
    public void guardarCliente(Cliente cliente) {
        clientesDao.save(cliente);
    }

    @Override
    public List<Cliente> mostrarClientes() {
        return (List<Cliente>)clientesDao.findAll();
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clientesDao.delete(cliente);
    }

    @Override
    public Cliente buscarCliente(Long id) {
        return clientesDao.findById(id).orElse(null);
    }
    
}
