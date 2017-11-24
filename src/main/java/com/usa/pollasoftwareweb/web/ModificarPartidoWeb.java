/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import javax.ejb.EJB;
import javax.inject.Named;

import com.usa.pollasoftwareweb.controlador.PartidoJpaController;
import com.usa.pollasoftwareweb.entidad.Partido;
import com.usa.pollasoftwareweb.exceptions.NonexistentEntityException;
import com.usa.pollasoftwareweb.exceptions.RollbackFailureException;
import java.math.BigInteger;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped

public class ModificarPartidoWeb {

    @EJB
    private PartidoJpaController partidosController;

    private String marcadorLocal;
    private String marcadorVisitante;
    private String idPartido;

    public String getMarcadorLocal() {
        return marcadorLocal;
    }

    public void setMarcadorLocal(String marcadorLocal) {
        this.marcadorLocal = marcadorLocal;
    }

    public String getMarcadorVisitante() {
        return marcadorVisitante;
    }

    public void setMarcadorVisitante(String marcadorVisitante) {
        this.marcadorVisitante = marcadorVisitante;
    }

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public String modificarPartido() throws NonexistentEntityException, RollbackFailureException, Exception {
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("hidden1");
        Partido partido = partidosController.findPartido(Integer.parseInt(value));
        partido.setMarcadorLocalFinal(new BigInteger(this.marcadorLocal));
        System.out.println("Marcador local");
        System.out.println(this.marcadorLocal);
        partido.setMarcadorVisitanteFinal(new BigInteger(this.marcadorVisitante));
        System.out.println("Marcador Final");
        System.out.println(this.marcadorVisitante);
        partidosController.edit(partido);
        return "crearPartidosAdmin";
    }

}
