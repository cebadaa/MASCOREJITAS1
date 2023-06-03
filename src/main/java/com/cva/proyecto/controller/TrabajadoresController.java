package com.cva.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cva.proyecto.model.entidad.Trabajador;
import com.cva.proyecto.model.service.ITrabajadorService;

@Controller
@RequestMapping("/trabajadores")
public class TrabajadoresController {
    @Autowired
    private ITrabajadorService trabajadorService;
    @RequestMapping("/")
    public String inicio(Model model){
        Trabajador trabajador=new Trabajador();
        model.addAttribute("trabajador", trabajador);
        model.addAttribute("listarTrabajador", trabajadorService.mostrarTrabajador());
        return "trabajadores/index";
    }
    @RequestMapping("/guardar")
    public String guardar(Trabajador trabajador){
        trabajadorService.guardarTrabajador(trabajador);
        return "redirect:/trabajadores/";
    }
    @RequestMapping("/eliminar/{id}")
    public String eliminar(Trabajador trabajador){
        trabajadorService.eliminarTrabajador(trabajador);
        return "redirect:/trabajadores/";
    }
    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Trabajador trabajador = new Trabajador();
        trabajador = trabajadorService.buscarTrabajador(id);
        model.addAttribute("trabajador", trabajador);
        model.addAttribute("titulo", "Editar Trabajador");
        model.addAttribute("listarTrabajador", trabajadorService.mostrarTrabajador());
        return "trabajadores/index";
    }
}
