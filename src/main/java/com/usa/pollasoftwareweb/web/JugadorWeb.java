/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import com.usa.pollasoftwareweb.controlador.JugadorJpaController;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.usa.pollasoftwareweb.entidad.Jugador;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped

public class JugadorWeb {

    @EJB
    private JugadorJpaController jugadoresController;

    private List<Jugador> jugadores;

    public void cargar() {
        jugadores = jugadoresController.findJugadorEntities();
    }

    public JugadorJpaController getJugadoresController() {
        return jugadoresController;
    }

    public void setJugadoresController(JugadorJpaController jugadoresController) {
        this.jugadoresController = jugadoresController;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @PostConstruct
    public void init() {
        jugadores = new LinkedList<>();
        cargar();
    }

}
