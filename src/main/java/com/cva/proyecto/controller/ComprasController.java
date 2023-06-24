package com.cva.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cva.proyecto.model.dao.IComprasDAO;
import com.cva.proyecto.model.entidad.Compras;
import com.cva.proyecto.model.entidad.Producto;
import com.cva.proyecto.model.service.ICarroService;
import com.cva.proyecto.model.service.IProductoService;
import com.cva.proyecto.model.service.ProductoService;

public class ComprasController {

    @Autowired
    private ICarroService carroService;

    @GetMapping("/shop/{id}")
    public String agregar(@PathVariable("id") Long idProducto, Model model) {

        Producto producto = obtenerProductoPorId(idProducto, model) //AQUI DEBO CREAR EL OBTENER EN PRODUCTO

        if (producto != null) {
            carroService.agregarProducto(producto, idProducto); // NO SE QUE PASA ACA XD
            model.addAttribute("mensaje", "Producto agregado al carrito correctamente.");
        } else {
            model.addAttribute("mensaje", "No se encontró el producto con el ID proporcionado.");
        }

        return "redirect:/product/" + idProducto;
    }

    @GetMapping("/x") //ESTE TECNICAMENTE SERIA EL "CARRITO DE COMPRAS"
    public String verCarrito(Model model) {
        
        List<Compras> productosCarrito = carroService.mostrarCarrito();


        double totalCarrito = carroService.calcularTotal();

        model.addAttribute("productosCarrito", productosCarrito);
        model.addAttribute("totalCarrito", totalCarrito);

        return "x";
    }


    @PostMapping("x")
    public String agregarCompra(@ModelAttribute Compras compra){
        carroService.guardarCompra(compra);//AGREGAR NUEVO METODO

        return "/dashboard/pedidos";
    }

}
