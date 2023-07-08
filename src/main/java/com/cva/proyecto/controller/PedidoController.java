package com.cva.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cva.proyecto.model.entidad.Pedido;
import com.cva.proyecto.model.service.IClienteService;
import com.cva.proyecto.model.service.IPedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private IPedidoService pedidoService;
    @Autowired
    private IClienteService clienteService;

    @RequestMapping("/")
    public String inicio(Model model){
        Pedido pedido = new Pedido();
        model.addAttribute("pedido", pedido);
        model.addAttribute("listaPedidos", pedidoService.mostrarPedidos());
        /*Metodo Spring */
        model.addAttribute("listaClientes", clienteService.mostrarCliOrdenAsc());
        return "pedido/index";
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String guardar(Pedido pedido){
        pedidoService.guardarPedido(pedido);
        return "redirect:/pedido/";
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        pedidoService.eliminarPedido(id);
        return "redirect:/pedido/";
    }
}
