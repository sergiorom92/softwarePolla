/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import com.usa.pollasoftwareweb.controlador.EquipoJpaController;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class CrearEquipoWebTest {
    
    public CrearEquipoWebTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetEquiposController() {
        System.out.println("getEquiposController");
        CrearEquipoWeb instance = new CrearEquipoWeb();
        EquipoJpaController expResult = null;
        EquipoJpaController result = instance.getEquiposController();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEquiposController() {
        System.out.println("setEquiposController");
        EquipoJpaController equiposController = null;
        CrearEquipoWeb instance = new CrearEquipoWeb();
        instance.setEquiposController(equiposController);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        CrearEquipoWeb instance = new CrearEquipoWeb();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        CrearEquipoWeb instance = new CrearEquipoWeb();
        instance.setNombre(nombre);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCrearEquipo() throws Exception {
        System.out.println("crearEquipo");
        CrearEquipoWeb instance = new CrearEquipoWeb();
        String expResult = "";
        String result = instance.crearEquipo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
