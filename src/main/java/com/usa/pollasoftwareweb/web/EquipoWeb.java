/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import com.usa.pollasoftwareweb.controlador.EquipoJpaController;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.usa.pollasoftwareweb.controlador.PartidoJpaController;
import com.usa.pollasoftwareweb.entidad.Equipo;
import com.usa.pollasoftwareweb.entidad.Partido;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped

public class EquipoWeb {

    @EJB
    private EquipoJpaController equiposController;

    private List<Equipo> equipos;

    public void cargar() {
        equipos = equiposController.findEquipoEntities();
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    @PostConstruct
    public void init() {
        equipos = new LinkedList<>();
        cargar();
    }

}
