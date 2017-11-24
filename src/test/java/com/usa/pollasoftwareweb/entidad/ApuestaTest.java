/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.entidad;

import java.math.BigInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class ApuestaTest {
    
    public ApuestaTest() {
    }
    
    @Before
    public void setUp() {
        
    }

    @Test
    public void testGetApuestaPK() {
        System.out.println("getApuestaPK");
        Apuesta instance = new Apuesta();
        ApuestaPK expResult = null;
        ApuestaPK result = instance.getApuestaPK();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetApuestaPK() {
        System.out.println("setApuestaPK");
        ApuestaPK apuestaPK = null;
        Apuesta instance = new Apuesta();
        instance.setApuestaPK(apuestaPK);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMarcadorLocal() {
        System.out.println("getMarcadorLocal");
        Apuesta instance = new Apuesta();
        BigInteger expResult = null;
        BigInteger result = instance.getMarcadorLocal();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetMarcadorLocal() {
        System.out.println("setMarcadorLocal");
        BigInteger marcadorLocal = null;
        Apuesta instance = new Apuesta();
        instance.setMarcadorLocal(marcadorLocal);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMarcadorVisitante() {
        System.out.println("getMarcadorVisitante");
        Apuesta instance = new Apuesta();
        BigInteger expResult = null;
        BigInteger result = instance.getMarcadorVisitante();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetMarcadorVisitante() {
        System.out.println("setMarcadorVisitante");
        BigInteger marcadorVisitante = null;
        Apuesta instance = new Apuesta();
        instance.setMarcadorVisitante(marcadorVisitante);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetJugador() {
        System.out.println("getJugador");
        Apuesta instance = new Apuesta();
        Jugador expResult = null;
        Jugador result = instance.getJugador();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetJugador() {
        System.out.println("setJugador");
        Jugador jugador = null;
        Apuesta instance = new Apuesta();
        instance.setJugador(jugador);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPartido() {
        System.out.println("getPartido");
        Apuesta instance = new Apuesta();
        Partido expResult = null;
        Partido result = instance.getPartido();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPartido() {
        System.out.println("setPartido");
        Partido partido = null;
        Apuesta instance = new Apuesta();
        instance.setPartido(partido);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Apuesta instance = new Apuesta();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Apuesta instance = new Apuesta();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Apuesta instance = new Apuesta();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
