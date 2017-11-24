/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import com.usa.pollasoftwareweb.entidad.Apuesta;
import com.usa.pollasoftwareweb.entidad.Jugador;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class ApuestaWebTest {
    
    public ApuestaWebTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testCargar() {
        System.out.println("cargar");
        ApuestaWeb instance = new ApuestaWeb();
        instance.cargar();
        //fail("The test case is a prototype.");
    }

    @Test
    public void testGetApuestas() {
        System.out.println("getApuestas");
        ApuestaWeb instance = new ApuestaWeb();
        List<Apuesta> expResult = null;
        List<Apuesta> result = instance.getApuestas();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetApuestas() {
        System.out.println("setApuestas");
        List<Apuesta> apuestas = null;
        ApuestaWeb instance = new ApuestaWeb();
        instance.setApuestas(apuestas);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetJugadoresApuesta() {
        System.out.println("getJugadoresApuesta");
        ApuestaWeb instance = new ApuestaWeb();
        Map<Jugador, Integer> expResult = null;
        Map<Jugador, Integer> result = instance.getJugadoresApuesta();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetJugadoresApuesta() {
        System.out.println("setJugadoresApuesta");
        Map<Jugador, Integer> jugadoresApuesta = null;
        ApuestaWeb instance = new ApuestaWeb();
        instance.setJugadoresApuesta(jugadoresApuesta);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInit() {
        System.out.println("init");
        ApuestaWeb instance = new ApuestaWeb();
        instance.init();
        fail("The test case is a prototype.");
    }
    
}
