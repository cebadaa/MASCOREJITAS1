package com.cva.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("titulo", "Registrar Nuevo Cliente");
        model.addAttribute("listarClientes", clienteService.mostrarClientes());
        return "clientes/index";
    }
    @RequestMapping("/guardar")
    public String guardar(Cliente cliente){
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes/";
    }
    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        clienteService.eliminarCliente(id);
        return "redirect:/clientes/";
    }
    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Cliente cliente = new Cliente();
        cliente = clienteService.buscarCliente(id);
        model.addAttribute("cliente", cliente);
        model.addAttribute("titulo", "Editar Cliente");
        model.addAttribute("listarClientes", clienteService.mostrarClientes());
        return "clientes/index";
    }

   

}
