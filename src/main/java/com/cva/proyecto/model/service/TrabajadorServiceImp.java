package com.cva.proyecto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cva.proyecto.model.dao.ITrabajadorDAO;
import com.cva.proyecto.model.entidad.Trabajador;

@Service
public class TrabajadorServiceImp implements ITrabajadorService{

    @Autowired
    private ITrabajadorDAO trabajadorDAO;

    @Override
    public void guardarTrabajador(Trabajador trabajador) {
        trabajadorDAO.save(trabajador);
    }

    @Override
    public List<Trabajador> mostrarTrabajador() {
        return(List<Trabajador>) trabajadorDAO.findAll();
    }
    
}
