package com.cva.proyecto.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cva.proyecto.model.dao.IDetalleDAO;
import com.cva.proyecto.model.entidad.Detalle;

@Service
public class DetalleServiceImp implements IDetalleService{
    @Autowired
    private IDetalleDAO detalleDAO;
    @Override
    public void guardarDetalle(Detalle detalle) {
        detalleDAO.save(detalle);
    }

    @Override
    public List<Detalle> listarDetalles() {
        return detalleDAO.findAllByOrderByIdAsc();
    }

    @Override
    public String eliminarDetalle(Long id) {
        String rpta = "";
        try{
            detalleDAO.deleteById(id);
            rpta = "Se eliminó el detalle correctamente";
        }catch(Exception e ){
            rpta = e.getMessage();
        }
        return rpta;
    }
    
}
