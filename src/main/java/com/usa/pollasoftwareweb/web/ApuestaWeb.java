/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import com.usa.pollasoftwareweb.controlador.ApuestaJpaController;
import com.usa.pollasoftwareweb.entidad.Apuesta;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.usa.pollasoftwareweb.entidad.Jugador;
import com.usa.pollasoftwareweb.entidad.Partido;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped

public class ApuestaWeb {

    @EJB
    private ApuestaJpaController apuestasController;

    private List<Apuesta> apuestas;
    private Map<Jugador, Integer> jugadoresApuesta;

    public void cargar() {
        apuestas = apuestasController.findApuestaEntities();
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(List<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

    public Map<Jugador, Integer> getJugadoresApuesta() {
        return jugadoresApuesta;
    }

    public void setJugadoresApuesta(Map<Jugador, Integer> jugadoresApuesta) {
        this.jugadoresApuesta = jugadoresApuesta;
    }

    @PostConstruct
    public void init() {
        apuestas = new LinkedList<>();
        jugadoresApuesta = new HashMap<>();
        cargar();
        calculaGanadores();
    }

    private void calculaGanadores() {

        for (Apuesta apuesta : apuestas) {
            if (apuesta.getPartido().getMarcadorLocalFinal() != null && apuesta.getPartido().getMarcadorVisitanteFinal() != null) {
                int puntuacion = 0;
                int diferenciaGoles = Math.abs((apuesta.getMarcadorLocal().intValue() - apuesta.getMarcadorVisitante().intValue()));
                Partido partido = apuesta.getPartido();
                if (partido.getMarcadorLocalFinal() == apuesta.getMarcadorLocal()
                        && partido.getMarcadorVisitanteFinal() == apuesta.getMarcadorVisitante()) {
                    puntuacion = 5;
                } else if (diferenciaGoles == Math.abs(partido.getMarcadorLocalFinal().intValue() - partido.getMarcadorVisitanteFinal().intValue())) {
                    puntuacion = 3;
                } else {
                    boolean ganaLocalPartido = partido.getMarcadorLocalFinal().intValue() > partido.getMarcadorVisitanteFinal().intValue();
                    boolean ganaLocalApuesta = apuesta.getMarcadorLocal().intValue() > apuesta.getMarcadorVisitante().intValue();
                    if (ganaLocalPartido == ganaLocalApuesta) {
                        puntuacion = 2;
                    }
                }
                if (this.jugadoresApuesta.get(apuesta.getJugador()) != null) {
                    int puntuacionAnterior = this.jugadoresApuesta.get(apuesta.getJugador());
                    this.jugadoresApuesta.put(apuesta.getJugador(), puntuacionAnterior + puntuacion);
                }
                this.jugadoresApuesta.put(apuesta.getJugador(), puntuacion);
            }
        }
    }

}
