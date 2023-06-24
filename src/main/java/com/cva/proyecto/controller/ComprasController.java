package com.cva.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cva.proyecto.model.entidad.Producto;
import com.cva.proyecto.model.service.ProductoService;

public class ComprasController {
    @Autowired
    private ProductoService productoService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/compras")
    public String mostrarPaginaCompras(Model model){
        List<Producto> productos = productoService.mostrarProductos();
        model.addAttribute("productos", productos);
        return "/compras";
    }

    @PostMapping("/compras/agregar")
    public String agregarCarrito(@RequestParam("id_pro") Long id_pro, @RequestParam("cantidad") int cantidad){
       Producto producto = productoService.obtenerProductoId(id_pro);
       for(CarritoItem item : carrito){
        if
       }
    }

    }
}
