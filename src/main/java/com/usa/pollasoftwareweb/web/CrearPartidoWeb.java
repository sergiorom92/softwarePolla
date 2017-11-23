/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import com.usa.pollasoftwareweb.entidad.Equipo;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.usa.pollasoftwareweb.entidad.Partido;
import com.usa.pollasoftwareweb.vista.EquipoJpaController;
import com.usa.pollasoftwareweb.vista.PartidoJpaController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sergio
 */
@Named
@RequestScoped

public class CrearPartidoWeb {

    @EJB
    private EquipoJpaController equiposController;

    @EJB
    private PartidoJpaController partidosController;

    private List<Equipo> equipos;
    private String equipoLocal;
    private String equipoVisitante;
    private String fecha;

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void cargar() {
        equipos = equiposController.findEquipoEntities();
    }

    public String crearPartido() throws ParseException, Exception {
        Date fechaInicio;
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        fechaInicio = format.parse(this.fecha);
        Partido partido = new Partido();
        partido.setIdEquipoLocal(equiposController.findEquipo(Integer.parseInt(this.equipoLocal)));
        partido.setIdEquipoVisitante(equiposController.findEquipo(Integer.parseInt(this.equipoVisitante)));
        partido.setHora(fechaInicio);
        partidosController.create(partido);
        return "crearPartidosAdmin";
    }

    @PostConstruct
    public void init() {
        equipos = new LinkedList<>();
        cargar();
    }

}
