package com.cva.proyecto.model.service;

import com.cva.proyecto.model.entidad.Cliente;
import com.cva.proyecto.model.entidad.Trabajador;

public interface IProductoService {
    public void guardarTrabajador(Trabajador trabajador);
    public void guardarCliente(Cliente cliente);
}
