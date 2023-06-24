package com.cva.proyecto.model.service;

//import java.util.List;

//import com.cva.proyecto.model.entidad.Compras;

public interface ICarroService {
    public void agregarProducto(Long id_pro);
    public void eliminarProducto(Long idProducto);
    public void actualizarProducto(Long id_pro, int cantidad);
    public void vaciarCarro();
    //public List<Compras> mostrarProductos();
    //double calcularTotal();

}
