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
public class EquipoTest {
    
    public EquipoTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetIdEquipo() {
        System.out.println("getIdEquipo");
        Equipo instance = new Equipo();
        Integer expResult = null;
        Integer result = instance.getIdEquipo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetIdEquipo() {
        System.out.println("setIdEquipo");
        Integer idEquipo = null;
        Equipo instance = new Equipo();
        instance.setIdEquipo(idEquipo);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Equipo instance = new Equipo();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Equipo instance = new Equipo();
        instance.setNombre(nombre);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPartidoList() {
        System.out.println("getPartidoList");
        Equipo instance = new Equipo();
        List<Partido> expResult = null;
        List<Partido> result = instance.getPartidoList();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPartidoList() {
        System.out.println("setPartidoList");
        List<Partido> partidoList = null;
        Equipo instance = new Equipo();
        instance.setPartidoList(partidoList);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPartidoList1() {
        System.out.println("getPartidoList1");
        Equipo instance = new Equipo();
        List<Partido> expResult = null;
        List<Partido> result = instance.getPartidoList1();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPartidoList1() {
        System.out.println("setPartidoList1");
        List<Partido> partidoList1 = null;
        Equipo instance = new Equipo();
        instance.setPartidoList1(partidoList1);
        fail("The test case is a prototype.");
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Equipo instance = new Equipo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Equipo instance = new Equipo();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Equipo instance = new Equipo();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
