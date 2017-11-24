/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.controlador;

import com.usa.pollasoftwareweb.entidad.Partido;
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
public class PartidoJpaControllerTest {
    
    public PartidoJpaControllerTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PartidoJpaController instance = (PartidoJpaController)container.getContext().lookup("java:global/classes/PartidoJpaController");
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Partido partido = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PartidoJpaController instance = (PartidoJpaController)container.getContext().lookup("java:global/classes/PartidoJpaController");
        instance.create(partido);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Partido partido = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PartidoJpaController instance = (PartidoJpaController)container.getContext().lookup("java:global/classes/PartidoJpaController");
        instance.edit(partido);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PartidoJpaController instance = (PartidoJpaController)container.getContext().lookup("java:global/classes/PartidoJpaController");
        instance.destroy(id);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindPartidoEntities_0args() throws Exception {
        System.out.println("findPartidoEntities");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PartidoJpaController instance = (PartidoJpaController)container.getContext().lookup("java:global/classes/PartidoJpaController");
        List<Partido> expResult = null;
        List<Partido> result = instance.findPartidoEntities();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindPartidoEntities_int_int() throws Exception {
        System.out.println("findPartidoEntities");
        int maxResults = 0;
        int firstResult = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PartidoJpaController instance = (PartidoJpaController)container.getContext().lookup("java:global/classes/PartidoJpaController");
        List<Partido> expResult = null;
        List<Partido> result = instance.findPartidoEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindPartido() throws Exception {
        System.out.println("findPartido");
        Integer id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PartidoJpaController instance = (PartidoJpaController)container.getContext().lookup("java:global/classes/PartidoJpaController");
        Partido expResult = null;
        Partido result = instance.findPartido(id);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPartidoCount() throws Exception {
        System.out.println("getPartidoCount");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        PartidoJpaController instance = (PartidoJpaController)container.getContext().lookup("java:global/classes/PartidoJpaController");
        int expResult = 0;
        int result = instance.getPartidoCount();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }
    
}
