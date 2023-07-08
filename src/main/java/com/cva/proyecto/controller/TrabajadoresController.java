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
    private ITrabajadorService iTrabajadorService;

    @RequestMapping("/")
    public String inicio(Model model){
        Trabajador trabajador=new Trabajador();
        model.addAttribute("trabajador", trabajador);
        model.addAttribute("titulo", "Registrar Nuevo Trabajador");
        model.addAttribute("listarTrabajador", iTrabajadorService.mostrarTrabajador());
        return "trabajadores/index";
    }
    @RequestMapping("/guardar")
    public String guardar(Trabajador trabajador){
        iTrabajadorService.guardarTrabajador(trabajador);
        return "redirect:/trabajadores/";
    }
    @RequestMapping("/eliminar/{id}")
    public String eliminar(Trabajador trabajador){
        iTrabajadorService.eliminarTrabajador(trabajador);
        return "redirect:/trabajadores/";
    }
    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Trabajador trabajador = new Trabajador();
        trabajador = iTrabajadorService.buscarTrabajador(id);
        model.addAttribute("trabajador", trabajador);
        model.addAttribute("titulo", "Editar Trabajador");
        model.addAttribute("listarTrabajador", iTrabajadorService.mostrarTrabajador());
        return "trabajadores/index";
    }
}
