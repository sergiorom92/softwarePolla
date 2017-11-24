/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import com.usa.pollasoftwareweb.entidad.Partido;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class PartidoWebTest {
    
    PartidoWeb mipartido;
    
    @Before
    public void setUp() {
        mipartido= new PartidoWeb();
    }
    
    @Test
    public void testSetPartidos() {
        
    }

    @Test
    public void testCargar() {
        System.out.println("cargar");
        PartidoWeb instance = new PartidoWeb();
        instance.cargar();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPartidos() {
    }

    @Test
    public void testInit() {
        System.out.println("init");
        PartidoWeb instance = new PartidoWeb();
        instance.init();
        fail("The test case is a prototype.");
    }
    
}
