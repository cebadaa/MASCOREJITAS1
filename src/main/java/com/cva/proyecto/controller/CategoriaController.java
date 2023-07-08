package com.cva.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cva.proyecto.model.entidad.Categoria;
import com.cva.proyecto.model.service.ICategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private ICategoriaService categoriaService;

    @RequestMapping("/")
    public String inicio(Model model){
        Categoria categoria=new Categoria();
        model.addAttribute("categoria", categoria);
        model.addAttribute("titulo", "Registrar Nueva Categoria");
        model.addAttribute("listacategoria",categoriaService.mostrarCategorias());
        return "categoria/index";
    }

    @RequestMapping("/guardar")
    public String guardar(Categoria categoria){
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categoria/";
    }

    @RequestMapping("/mostrarEditar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Categoria categoria=new Categoria();
        categoria=categoriaService.buscarCategoria(id);
        model.addAttribute("categoria",categoria);
        model.addAttribute("titulo", "Modificar Categoria");
        model.addAttribute("listacategoria",categoriaService.mostrarCategorias());
        return "categoria/index";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        categoriaService.eliminarCategoria(id);
        return "redirect:/categoria/";
    }
}