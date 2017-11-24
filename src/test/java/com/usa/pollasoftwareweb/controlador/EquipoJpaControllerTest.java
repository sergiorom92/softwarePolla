/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.controlador;

import com.usa.pollasoftwareweb.entidad.Equipo;
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
public class EquipoJpaControllerTest {
    
    public EquipoJpaControllerTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EquipoJpaController instance = (EquipoJpaController)container.getContext().lookup("java:global/classes/EquipoJpaController");
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Equipo equipo = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EquipoJpaController instance = (EquipoJpaController)container.getContext().lookup("java:global/classes/EquipoJpaController");
        instance.create(equipo);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Equipo equipo = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EquipoJpaController instance = (EquipoJpaController)container.getContext().lookup("java:global/classes/EquipoJpaController");
        instance.edit(equipo);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        Integer id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EquipoJpaController instance = (EquipoJpaController)container.getContext().lookup("java:global/classes/EquipoJpaController");
        instance.destroy(id);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindEquipoEntities_0args() throws Exception {
        System.out.println("findEquipoEntities");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EquipoJpaController instance = (EquipoJpaController)container.getContext().lookup("java:global/classes/EquipoJpaController");
        List<Equipo> expResult = null;
        List<Equipo> result = instance.findEquipoEntities();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindEquipoEntities_int_int() throws Exception {
        System.out.println("findEquipoEntities");
        int maxResults = 0;
        int firstResult = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EquipoJpaController instance = (EquipoJpaController)container.getContext().lookup("java:global/classes/EquipoJpaController");
        List<Equipo> expResult = null;
        List<Equipo> result = instance.findEquipoEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindEquipo() throws Exception {
        System.out.println("findEquipo");
        Integer id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EquipoJpaController instance = (EquipoJpaController)container.getContext().lookup("java:global/classes/EquipoJpaController");
        Equipo expResult = null;
        Equipo result = instance.findEquipo(id);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEquipoCount() throws Exception {
        System.out.println("getEquipoCount");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        EquipoJpaController instance = (EquipoJpaController)container.getContext().lookup("java:global/classes/EquipoJpaController");
        int expResult = 0;
        int result = instance.getEquipoCount();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }
    
}
