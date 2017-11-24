/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.entidad;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class PartidoTest {
    
    public PartidoTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetIdPartido() {
        System.out.println("getIdPartido");
        Partido instance = new Partido();
        Integer expResult = null;
        Integer result = instance.getIdPartido();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetIdPartido() {
        System.out.println("setIdPartido");
        Integer idPartido = null;
        Partido instance = new Partido();
        instance.setIdPartido(idPartido);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetHora() {
        System.out.println("getHora");
        Partido instance = new Partido();
        Date expResult = null;
        Date result = instance.getHora();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetHora() {
        System.out.println("setHora");
        Date hora = null;
        Partido instance = new Partido();
        instance.setHora(hora);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMarcadorLocalFinal() {
        System.out.println("getMarcadorLocalFinal");
        Partido instance = new Partido();
        BigInteger expResult = null;
        BigInteger result = instance.getMarcadorLocalFinal();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetMarcadorLocalFinal() {
        System.out.println("setMarcadorLocalFinal");
        BigInteger marcadorLocalFinal = null;
        Partido instance = new Partido();
        instance.setMarcadorLocalFinal(marcadorLocalFinal);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetMarcadorVisitanteFinal() {
        System.out.println("getMarcadorVisitanteFinal");
        Partido instance = new Partido();
        BigInteger expResult = null;
        BigInteger result = instance.getMarcadorVisitanteFinal();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetMarcadorVisitanteFinal() {
        System.out.println("setMarcadorVisitanteFinal");
        BigInteger marcadorVisitanteFinal = null;
        Partido instance = new Partido();
        instance.setMarcadorVisitanteFinal(marcadorVisitanteFinal);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetApuestaList() {
        System.out.println("getApuestaList");
        Partido instance = new Partido();
        List<Apuesta> expResult = null;
        List<Apuesta> result = instance.getApuestaList();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetApuestaList() {
        System.out.println("setApuestaList");
        List<Apuesta> apuestaList = null;
        Partido instance = new Partido();
        instance.setApuestaList(apuestaList);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetIdEquipoLocal() {
        System.out.println("getIdEquipoLocal");
        Partido instance = new Partido();
        Equipo expResult = null;
        Equipo result = instance.getIdEquipoLocal();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetIdEquipoLocal() {
        System.out.println("setIdEquipoLocal");
        Equipo idEquipoLocal = null;
        Partido instance = new Partido();
        instance.setIdEquipoLocal(idEquipoLocal);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetIdEquipoVisitante() {
        System.out.println("getIdEquipoVisitante");
        Partido instance = new Partido();
        Equipo expResult = null;
        Equipo result = instance.getIdEquipoVisitante();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetIdEquipoVisitante() {
        System.out.println("setIdEquipoVisitante");
        Equipo idEquipoVisitante = null;
        Partido instance = new Partido();
        instance.setIdEquipoVisitante(idEquipoVisitante);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Partido instance = new Partido();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Partido instance = new Partido();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Partido instance = new Partido();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
