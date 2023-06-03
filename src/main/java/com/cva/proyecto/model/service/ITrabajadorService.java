package com.cva.proyecto.model.service;

import java.util.List;

import com.cva.proyecto.model.entidad.Trabajador;

public interface ITrabajadorService {
    public void guardarTrabajador(Trabajador trabajador);
    public List<Trabajador> mostrarTrabajador();
}
