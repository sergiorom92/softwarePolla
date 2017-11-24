/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class CrearJugadorWebTest {
    
    public CrearJugadorWebTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetCorreo() {
        System.out.println("getCorreo");
        CrearJugadorWeb instance = new CrearJugadorWeb();
        String expResult = "";
        String result = instance.getCorreo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCorreo() {
        System.out.println("setCorreo");
        String correo = "";
        CrearJugadorWeb instance = new CrearJugadorWeb();
        instance.setCorreo(correo);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAlias() {
        System.out.println("getAlias");
        CrearJugadorWeb instance = new CrearJugadorWeb();
        String expResult = "";
        String result = instance.getAlias();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetAlias() {
        System.out.println("setAlias");
        String alias = "";
        CrearJugadorWeb instance = new CrearJugadorWeb();
        instance.setAlias(alias);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        CrearJugadorWeb instance = new CrearJugadorWeb();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        CrearJugadorWeb instance = new CrearJugadorWeb();
        instance.setPassword(password);
        fail("The test case is a prototype.");
    }

    @Test
    public void testCrearJugador() throws Exception {
        System.out.println("crearJugador");
        CrearJugadorWeb instance = new CrearJugadorWeb();
        String expResult = "";
        String result = instance.crearJugador();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
