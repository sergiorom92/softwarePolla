/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.seguridad;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class SessionUtilsTest {
    
    public SessionUtilsTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testGetSession() {
        System.out.println("getSession");
        HttpSession expResult = null;
        HttpSession result = SessionUtils.getSession();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetRequest() {
        System.out.println("getRequest");
        HttpServletRequest expResult = null;
        HttpServletRequest result = SessionUtils.getRequest();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        String expResult = "";
        String result = SessionUtils.getUserName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        String expResult = "";
        String result = SessionUtils.getUserId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
