package com.cva.proyecto.model.service;
import java.util.List;

import com.cva.proyecto.model.entidad.Detalle;

public interface IDetalleService {
    public void guardarDetalle(Detalle detalle);
    public List<Detalle> listarDetalles();
    public String eliminarDetalle(Long id);
}
