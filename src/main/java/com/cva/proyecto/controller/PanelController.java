package com.cva.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PanelController {

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
    public String shop(){
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
