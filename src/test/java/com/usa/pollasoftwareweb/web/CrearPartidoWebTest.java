
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import com.usa.pollasoftwareweb.entidad.Equipo;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class CrearPartidoWebTest {
    
    public CrearPartidoWebTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetEquipos() {
        System.out.println("getEquipos");
        CrearPartidoWeb instance = new CrearPartidoWeb();
        List<Equipo> expResult = null;
        List<Equipo> result = instance.getEquipos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEquipos() {
        System.out.println("setEquipos");
        List<Equipo> equipos = null;
        CrearPartidoWeb instance = new CrearPartidoWeb();
        instance.setEquipos(equipos);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEquipoLocal() {
        System.out.println("getEquipoLocal");
        CrearPartidoWeb instance = new CrearPartidoWeb();
        String expResult = "";
        String result = instance.getEquipoLocal();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEquipoLocal() {
        System.out.println("setEquipoLocal");
        String equipoLocal = "";
        CrearPartidoWeb instance = new CrearPartidoWeb();
        instance.setEquipoLocal(equipoLocal);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEquipoVisitante() {
        System.out.println("getEquipoVisitante");
        CrearPartidoWeb instance = new CrearPartidoWeb();
        String expResult = "";
        String result = instance.getEquipoVisitante();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEquipoVisitante() {
        System.out.println("setEquipoVisitante");
        String equipoVisitante = "";
        CrearPartidoWeb instance = new CrearPartidoWeb();
        instance.setEquipoVisitante(equipoVisitante);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        CrearPartidoWeb instance = new CrearPartidoWeb();
        String expResult = "";
        String result = instance.getFecha();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        String fecha = "";
        CrearPartidoWeb instance = new CrearPartidoWeb();
        instance.setFecha(fecha);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCargar() {
        System.out.println("cargar");
        CrearPartidoWeb instance = new CrearPartidoWeb();
        instance.cargar();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCrearPartido() throws Exception {
        System.out.println("crearPartido");
        CrearPartidoWeb instance = new CrearPartidoWeb();
        String expResult = "";
        String result = instance.crearPartido();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInit() {
        System.out.println("init");
        CrearPartidoWeb instance = new CrearPartidoWeb();
        instance.init();
        fail("The test case is a prototype.");
    }
    
}
