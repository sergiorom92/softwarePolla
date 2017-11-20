/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.usa.pollasoftwareweb.vista.PartidoJpaController;

import com.usa.pollasoftwareweb.entidad.Partido;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped

public class PartidoWeb {

    @EJB
    private PartidoJpaController partidosController;

    private List<Partido> partidos;

    public void cargar() {
        partidos = partidosController.findPartidoEntities();
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    @PostConstruct
    public void init() {
        partidos = new LinkedList<>();
        cargar();
    }

}
