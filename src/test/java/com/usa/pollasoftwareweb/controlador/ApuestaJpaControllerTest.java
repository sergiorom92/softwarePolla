/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.controlador;

import com.usa.pollasoftwareweb.entidad.Apuesta;
import com.usa.pollasoftwareweb.entidad.ApuestaPK;
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
public class ApuestaJpaControllerTest {
    
    public ApuestaJpaControllerTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ApuestaJpaController instance = (ApuestaJpaController)container.getContext().lookup("java:global/classes/ApuestaJpaController");
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Apuesta apuesta = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ApuestaJpaController instance = (ApuestaJpaController)container.getContext().lookup("java:global/classes/ApuestaJpaController");
        instance.create(apuesta);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Apuesta apuesta = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ApuestaJpaController instance = (ApuestaJpaController)container.getContext().lookup("java:global/classes/ApuestaJpaController");
        instance.edit(apuesta);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testDestroy() throws Exception {
        System.out.println("destroy");
        ApuestaPK id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ApuestaJpaController instance = (ApuestaJpaController)container.getContext().lookup("java:global/classes/ApuestaJpaController");
        instance.destroy(id);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindApuestaEntities_0args() throws Exception {
        System.out.println("findApuestaEntities");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ApuestaJpaController instance = (ApuestaJpaController)container.getContext().lookup("java:global/classes/ApuestaJpaController");
        List<Apuesta> expResult = null;
        List<Apuesta> result = instance.findApuestaEntities();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindApuestaEntities_int_int() throws Exception {
        System.out.println("findApuestaEntities");
        int maxResults = 0;
        int firstResult = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ApuestaJpaController instance = (ApuestaJpaController)container.getContext().lookup("java:global/classes/ApuestaJpaController");
        List<Apuesta> expResult = null;
        List<Apuesta> result = instance.findApuestaEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindApuesta() throws Exception {
        System.out.println("findApuesta");
        ApuestaPK id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ApuestaJpaController instance = (ApuestaJpaController)container.getContext().lookup("java:global/classes/ApuestaJpaController");
        Apuesta expResult = null;
        Apuesta result = instance.findApuesta(id);
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetApuestaCount() throws Exception {
        System.out.println("getApuestaCount");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        ApuestaJpaController instance = (ApuestaJpaController)container.getContext().lookup("java:global/classes/ApuestaJpaController");
        int expResult = 0;
        int result = instance.getApuestaCount();
        assertEquals(expResult, result);
        container.close();
        fail("The test case is a prototype.");
    }
    
}
