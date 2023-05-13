package com.cva.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PanelController {

    @RequestMapping("/")
    public String panel(){
        return "dashboard";
    }

}
