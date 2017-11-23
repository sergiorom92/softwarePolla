/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import com.usa.pollasoftwareweb.vista.EquipoJpaController;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.usa.pollasoftwareweb.entidad.Equipo;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped

public class CrearEquipoWeb {

    @EJB
    private EquipoJpaController equiposController;
    private String nombre;

    public EquipoJpaController getEquiposController() {
        return equiposController;
    }

    public void setEquiposController(EquipoJpaController equiposController) {
        this.equiposController = equiposController;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String crearEquipo() throws Exception {
        equiposController.create(new Equipo(nombre));
        return "equipos";
    }

}
