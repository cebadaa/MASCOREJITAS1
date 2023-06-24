package com.cva.proyecto.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cva.proyecto.model.entidad.Compras;
import com.cva.proyecto.model.service.ICarroService;

@Controller
public class PedidoController {
    private ICarroService carroService;

    @GetMapping("/dashboard/pedidos")
    public String mostrarDashboard(Model model) {
        List<Compras> compras = carroService.mostrarCarrito();
        model.addAttribute("compras", compras);
        return "/dashboard/pedidos";
    }

    @GetMapping("/dashboard/eliminar/{idCompra}")
    public String eliminarCompra(@PathVariable Long idCompra) {
        carroService.eliminarProducto(idCompra);
        return "redirect:/dashboard/pedidos";
    }

    @GetMapping("/dashboard/editar/{idCompra}")
    public String editarCompra(@PathVariable Long idCompra, Model model) {
        Compras compra = carroService.actualizarProducto(idCompra);
        model.addAttribute("compra", compra);
        return "/dashboard/editar";
    }

    @PostMapping("/dashboard/editar") //CONFIRMACION DE EDICION DE PEDIDO
    public String guardarEdicionCompra(@ModelAttribute Compras compra) {
        carroService.actualizarProducto(compra);
        return "redirect:/dashboard/pedidos";
    }
}
