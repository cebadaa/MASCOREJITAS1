package com.cva.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cva.proyecto.model.entidad.Producto;
import com.cva.proyecto.model.service.IProductoService;

@Controller
public class PanelController {
    //localhost:8080/
    @Autowired
    private IProductoService productoService;
    @RequestMapping(value = {"/dashboard/"})
    public String panel(){
        return "dashboard";
    }

    @RequestMapping("/")
    public String inicio(){
        return "index";
    }
    @RequestMapping("/autenticacion")
    public String login(){
        return "logueo";
    }
    @RequestMapping("/nosotros")
    public String nosotros(){
        return "about";
    }
    @RequestMapping("/shop")
    public String shop(Model model){
        Producto producto=new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("listarProducto", productoService.mostrarProductos());
        return "shop";
    }
    @RequestMapping("/furniture")
    public String furniture(){
        return "furniture";
    }
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }
    


}
