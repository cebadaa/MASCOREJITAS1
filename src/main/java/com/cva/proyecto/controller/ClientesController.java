package com.cva.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cva.proyecto.model.entidad.Cliente;
import com.cva.proyecto.model.service.IProductoService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private IProductoService productoService;
    @RequestMapping("/")
    public String inicio(Model model){
        Cliente cliente=new Cliente();
        model.addAttribute("cliente", cliente);
        return "clientes/index";
    }
    @RequestMapping("/guardar")
    public String guardar(Cliente cliente){
        productoService.guardarCliente(cliente);
        return "redirect:/clientes/";
    }
}
