package com.cva.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cva.proyecto.model.entidad.Detalle;
import com.cva.proyecto.model.service.ICategoriaService;
import com.cva.proyecto.model.service.IDetalleService;
import com.cva.proyecto.model.service.IPedidoService;
import com.cva.proyecto.model.service.IProductoService;

@Controller
@RequestMapping("/detalle")
public class DetalleController {
    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IPedidoService pedidoService;

    @Autowired
    private IDetalleService detalleService;

    @RequestMapping("/")
    public String inicio(Model model){
        Detalle detalle = new Detalle();
        model.addAttribute("detalle", detalle);
        model.addAttribute("listaDetalles", detalleService.listarDetalles());
        /*Metodo Spring */
        model.addAttribute("listaPedidos", pedidoService.mostrarPeOrdenAsc());
        model.addAttribute("listaProductos", productoService.mostrarProOrdenAsc());
        model.addAttribute("listaCategorias", categoriaService.mostrarCatOrdenAsc());

        return "detalle/index";
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String guardar(Detalle detalle){
        detalleService.guardarDetalle(detalle);
        return "redirect:/detalle/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash){
        String rpta = detalleService.eliminarDetalle(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/detalle/";
    }
}
