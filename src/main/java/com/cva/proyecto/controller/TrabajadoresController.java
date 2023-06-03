package com.cva.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
}
