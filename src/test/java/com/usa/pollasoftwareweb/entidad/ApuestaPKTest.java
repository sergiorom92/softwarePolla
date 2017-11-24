/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.entidad;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class ApuestaPKTest {

    @Test
    public void testGetIdJugador() {
    }

    @Test
    public void testSetIdJugador() {
        System.out.println("setIdJugador");
        String idJugador = "";
        ApuestaPK instance = new ApuestaPK();
        instance.setIdJugador(idJugador);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetIdPartido() {
        System.out.println("getIdPartido");
        ApuestaPK instance = new ApuestaPK();
        int expResult = 0;
        int result = instance.getIdPartido();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetIdPartido() {
        System.out.println("setIdPartido");
        int idPartido = 0;
        ApuestaPK instance = new ApuestaPK();
        instance.setIdPartido(idPartido);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ApuestaPK instance = new ApuestaPK();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        ApuestaPK instance = new ApuestaPK();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        ApuestaPK instance = new ApuestaPK();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
