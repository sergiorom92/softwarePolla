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
public class EquipoWebTest {
    
    public EquipoWebTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testCargar() {
        System.out.println("cargar");
        EquipoWeb instance = new EquipoWeb();
        instance.cargar();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEquipos() {
        System.out.println("getEquipos");
        EquipoWeb instance = new EquipoWeb();
        List<Equipo> expResult = null;
        List<Equipo> result = instance.getEquipos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEquipos() {
        System.out.println("setEquipos");
        List<Equipo> equipos = null;
        EquipoWeb instance = new EquipoWeb();
        instance.setEquipos(equipos);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInit() {
        System.out.println("init");
        EquipoWeb instance = new EquipoWeb();
        instance.init();
        fail("The test case is a prototype.");
    }
    
}
