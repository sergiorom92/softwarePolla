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

import com.usa.pollasoftwareweb.controlador.PartidoJpaController;

import com.usa.pollasoftwareweb.entidad.Partido;
import java.util.Map;
import javax.faces.context.FacesContext;

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

    private String partidoActual;

    public String getPartidoActual() {
        return partidoActual;
    }

    public void setPartidoActual(String partidoActual) {
        this.partidoActual = partidoActual;
    }

    public void cargar() {
        partidos = partidosController.findPartidoEntities();
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    private String getPartidoFromJSF(FacesContext context) {
        Map<String, String> parameters = context.getExternalContext().getRequestParameterMap();
        return parameters.get("partidoActual");
    }

    public String outcome() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.partidoActual = getPartidoFromJSF(context);
        return "apostarPartido";
    }

    @PostConstruct
    public void init() {
        partidos = new LinkedList<>();
        cargar();
    }

    public String execute() {
        // ...
        return "/apostarPartido.xhtml?faces-redirect=true";
    }

}
