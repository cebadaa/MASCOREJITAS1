package com.cva.proyecto.model.dao;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cva.proyecto.model.entidad.Detalle;


public interface IDetalleDAO extends CrudRepository<Detalle, Long>{
    public List<Detalle> findAllByOrderByIdAsc();
}
