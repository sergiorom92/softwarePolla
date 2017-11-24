/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.entidad;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class JugadorTest {
    
    public JugadorTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetIdJugador() {
        System.out.println("getIdJugador");
        Jugador instance = new Jugador();
        String expResult = "";
        String result = instance.getIdJugador();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetIdJugador() {
        System.out.println("setIdJugador");
        String idJugador = "";
        Jugador instance = new Jugador();
        instance.setIdJugador(idJugador);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAlias() {
        System.out.println("getAlias");
        Jugador instance = new Jugador();
        String expResult = "";
        String result = instance.getAlias();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetAlias() {
        System.out.println("setAlias");
        String alias = "";
        Jugador instance = new Jugador();
        instance.setAlias(alias);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Jugador instance = new Jugador();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Jugador instance = new Jugador();
        instance.setPassword(password);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetAdministrador() {
        System.out.println("getAdministrador");
        Jugador instance = new Jugador();
        boolean expResult = false;
        boolean result = instance.getAdministrador();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetAdministrador() {
        System.out.println("setAdministrador");
        boolean administrador = false;
        Jugador instance = new Jugador();
        instance.setAdministrador(administrador);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetApuestaList() {
        System.out.println("getApuestaList");
        Jugador instance = new Jugador();
        List<Apuesta> expResult = null;
        List<Apuesta> result = instance.getApuestaList();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetApuestaList() {
        System.out.println("setApuestaList");
        List<Apuesta> apuestaList = null;
        Jugador instance = new Jugador();
        instance.setApuestaList(apuestaList);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Jugador instance = new Jugador();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Jugador instance = new Jugador();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Jugador instance = new Jugador();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
