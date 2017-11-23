/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import com.usa.pollasoftwareweb.vista.JugadorJpaController;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.usa.pollasoftwareweb.entidad.Jugador;
import com.usa.pollasoftwareweb.exceptions.RollbackFailureException;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped

public class CrearJugadorWeb {

    @EJB
    private JugadorJpaController jugadoresController;
    private String correo;
    private String alias;
    private String password;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String crearJugador() throws RollbackFailureException, Exception {
        jugadoresController.create(new Jugador(correo, alias, password, false));
        return "index";
    }

}
