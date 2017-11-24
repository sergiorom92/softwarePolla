/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import com.usa.pollasoftwareweb.entidad.Jugador;
import com.usa.pollasoftwareweb.controlador.JugadorJpaController;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class JugadorWebTest {
    
    @Before
    public void setUp() {
    }

    @Test
    public void testCargar() {
        System.out.println("cargar");
        JugadorWeb instance = new JugadorWeb();
        instance.cargar();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetJugadoresController() {
        System.out.println("getJugadoresController");
        JugadorWeb instance = new JugadorWeb();
        JugadorJpaController expResult = null;
        JugadorJpaController result = instance.getJugadoresController();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetJugadoresController() {
        System.out.println("setJugadoresController");
        JugadorJpaController jugadoresController = null;
        JugadorWeb instance = new JugadorWeb();
        instance.setJugadoresController(jugadoresController);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetJugadores() {
        System.out.println("getJugadores");
        JugadorWeb instance = new JugadorWeb();
        List<Jugador> expResult = null;
        List<Jugador> result = instance.getJugadores();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetJugadores() {
        System.out.println("setJugadores");
        List<Jugador> jugadores = null;
        JugadorWeb instance = new JugadorWeb();
        instance.setJugadores(jugadores);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInit() {
        System.out.println("init");
        JugadorWeb instance = new JugadorWeb();
        instance.init();
        fail("The test case is a prototype.");
    }
    
}
