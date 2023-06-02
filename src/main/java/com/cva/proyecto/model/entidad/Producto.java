package com.cva.proyecto.model.entidad;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pro")
    private Long id;

    @Column(name = "nombre_pro")
    private String nombre;

    @Column(name = "precio_pro")
    private double precio;

    @Column(name = "id_cat")
    private Long idCat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Long getIdCat() {
        return idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }


}
