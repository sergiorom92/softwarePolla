/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import com.usa.pollasoftwareweb.controlador.ApuestaJpaController;
import com.usa.pollasoftwareweb.controlador.JugadorJpaController;
import javax.ejb.EJB;
import javax.inject.Named;

import com.usa.pollasoftwareweb.controlador.PartidoJpaController;
import com.usa.pollasoftwareweb.entidad.Apuesta;
import com.usa.pollasoftwareweb.entidad.ApuestaPK;
import com.usa.pollasoftwareweb.entidad.Partido;
import com.usa.pollasoftwareweb.exceptions.RollbackFailureException;
import java.math.BigInteger;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped

public class ApostarPartidoWeb {

    @EJB
    private ApuestaJpaController apuestasController;
    @EJB
    private JugadorJpaController jugadoresController;
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

    public String agregarMarcador() throws RollbackFailureException, Exception {
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("hidden1");
        String value2 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("hidden2");

        if (partidosController.findPartido(Integer.parseInt(value)).getHora().getTime() < System.currentTimeMillis()) {
            return "partidos";
        }

        Apuesta apuesta = new Apuesta();

        apuesta.setMarcadorLocal(new BigInteger(this.marcadorLocal));
        apuesta.setMarcadorVisitante(new BigInteger(this.marcadorVisitante));

        apuesta.setPartido(partidosController.findPartido(Integer.parseInt(value)));
        apuesta.setJugador(jugadoresController.findJugador(value2));
        apuesta.setApuestaPK(new ApuestaPK(value2, Integer.parseInt(value)));

        Apuesta apuestaExistente = apuestasController.findApuesta(new ApuestaPK(value2, Integer.parseInt(value)));
        if (apuestaExistente != null) {
            apuestasController.edit(apuesta);
            return "partidos";
        }
        apuestasController.create(apuesta);
        return "partidos";
    }

}
