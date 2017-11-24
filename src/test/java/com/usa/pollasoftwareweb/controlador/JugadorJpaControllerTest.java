/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.controlador;

import com.usa.pollasoftwareweb.entidad.Jugador;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class JugadorJpaControllerTest {
    
    public JugadorJpaControllerTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        JugadorJpaController instance = (JugadorJpaController)container.getContext().lookup("java:global/classes/JugadorJpaController");
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Jugador jugador = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        JugadorJpaController instance = (JugadorJpaController)container.getContext().lookup("java:global/classes/JugadorJpaController");
        instance.create(jugador);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Jugador jugador = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        JugadorJpaController instance = (JugadorJpaController)container.getContext().lookup("java:global/classes/JugadorJpaController");
        instance.edit(jugador);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        String id = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        JugadorJpaController instance = (JugadorJpaController)container.getContext().lookup("java:global/classes/JugadorJpaController");
        instance.destroy(id);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindJugadorEntities_0args() throws Exception {
        System.out.println("findJugadorEntities");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        JugadorJpaController instance = (JugadorJpaController)container.getContext().lookup("java:global/classes/JugadorJpaController");
        List<Jugador> expResult = null;
        List<Jugador> result = instance.findJugadorEntities();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindJugadorEntities_int_int() throws Exception {
        System.out.println("findJugadorEntities");
        int maxResults = 0;
        int firstResult = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        JugadorJpaController instance = (JugadorJpaController)container.getContext().lookup("java:global/classes/JugadorJpaController");
        List<Jugador> expResult = null;
        List<Jugador> result = instance.findJugadorEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindJugador() throws Exception {
        System.out.println("findJugador");
        String id = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        JugadorJpaController instance = (JugadorJpaController)container.getContext().lookup("java:global/classes/JugadorJpaController");
        Jugador expResult = null;
        Jugador result = instance.findJugador(id);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetJugadorCount() throws Exception {
        System.out.println("getJugadorCount");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        JugadorJpaController instance = (JugadorJpaController)container.getContext().lookup("java:global/classes/JugadorJpaController");
        int expResult = 0;
        int result = instance.getJugadorCount();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }
    
}
