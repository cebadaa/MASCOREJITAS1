package com.cva.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cva.proyecto.model.entidad.Cliente;
import com.cva.proyecto.model.service.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private IClienteService clienteService;
    @RequestMapping("/")
    public String inicio(Model model){
        Cliente cliente=new Cliente();
        model.addAttribute("cliente", cliente);
        model.addAttribute("listarClientes", clienteService.mostrarClientes());
        return "clientes/index";
    }
    @RequestMapping("/guardar")
    public String guardar(Cliente cliente){
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes/";
    }
}
