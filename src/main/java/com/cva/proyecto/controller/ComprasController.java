package com.cva.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cva.proyecto.model.dao.IComprasDAO;
import com.cva.proyecto.model.entidad.Producto;
import com.cva.proyecto.model.service.ICarroService;
import com.cva.proyecto.model.service.ProductoService;

public class ComprasController {
    @Autowired
    private ICarroService carroService;

   
}
