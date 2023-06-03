package com.cva.proyecto.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cva.proyecto.model.dao.IClienteDAO;
import com.cva.proyecto.model.dao.ITrabajadorDAO;
import com.cva.proyecto.model.entidad.Cliente;
import com.cva.proyecto.model.entidad.Trabajador;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private ITrabajadorDAO trabajadorDAO;
    @Override
    public void guardarTrabajador(Trabajador trabajador) {
        trabajadorDAO.save(trabajador);
    }    
    @Autowired
    private IClienteDAO clienteDAO;
    @Override
    public void guardarCliente(Cliente cliente) {
        clienteDAO.save(cliente);
    }
    
}
