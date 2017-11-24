/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.web;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class LoginTest {
    Login milogin;
    
    @Before
    public void setUp() {
        milogin= new Login();
    }

    @Test
    public void testGetPassword() {
        milogin.setPassword("hola");
        String p1=milogin.getPassword();
        assertEquals(p1, "hola");
    }

    

    @Test
    public void testGetUser() {
    }

    
    @Test
    public void testGetAlias() {
        System.out.println("getAlias");
        Login instance = new Login();
        String expResult = "";
        String result = instance.getAlias();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSetAlias() {
        System.out.println("setAlias");
        String alias = "";
        Login instance = new Login();
        instance.setAlias(alias);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testValidateUsernamePassword() {
        System.out.println("validateUsernamePassword");
        Login instance = new Login();
        String expResult = "";
        String result = instance.validateUsernamePassword();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testLogout() {
        assertEquals(milogin.logout(), "index");
    }
    
}
