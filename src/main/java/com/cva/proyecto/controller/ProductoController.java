package com.cva.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cva.proyecto.model.entidad.Producto;
import com.cva.proyecto.model.service.ICategoriaService;
import com.cva.proyecto.model.service.IProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private ICategoriaService categoriaService;

    @Autowired
    private IProductoService productoService;

    @RequestMapping("/")
    public String inicio(Model model){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("listaProductos", productoService.listarProductos());
        /*Metodo Spring */
        model.addAttribute("listaCategorias", categoriaService.mostrarCatOrdenAsc());
        /*Metodo sql 
        model.addAttribute("listaCategorias", categoriaService.mostrarLike("%s%"));*/
        return "producto/index";
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String guardar(Producto producto){
        productoService.guardarProducto(producto);
        return "redirect:/producto/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id, Model model, RedirectAttributes flash){
        String rpta = productoService.eliminarProducto(id);
        flash.addFlashAttribute("mensaje", rpta);
        return "redirect:/producto/";
    }
}
