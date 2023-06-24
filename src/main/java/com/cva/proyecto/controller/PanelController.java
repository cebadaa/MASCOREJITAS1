package com.cva.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cva.proyecto.model.entidad.Trabajador;
import com.cva.proyecto.model.service.ITrabajadorService;

@Controller
public class PanelController {
    //localhost:8080/
    @Autowired
    private ITrabajadorService trabajadorService;
    @RequestMapping(value = {"/dashboard"})
    public String panel(){
        return "dashboard";
    }

    @RequestMapping("/")
    public String inicio(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/nosotros")
    public String nosotros(){
        return "about";
    }
    @RequestMapping("/shop")
    public String shop(Model model){
        Trabajador trabajador=new Trabajador();
        model.addAttribute("trabajador", trabajador);
        model.addAttribute("listarTrabajador", trabajadorService.mostrarTrabajador());
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
