/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.pollasoftwareweb.seguridad;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juan
 */
public class AuthorizationFilterTest {
    
    public AuthorizationFilterTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testInit() throws Exception {
        System.out.println("init");
        FilterConfig filterConfig = null;
        AuthorizationFilter instance = new AuthorizationFilter();
        instance.init(filterConfig);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDoFilter() throws Exception {
        System.out.println("doFilter");
        ServletRequest request = null;
        ServletResponse response = null;
        FilterChain chain = null;
        AuthorizationFilter instance = new AuthorizationFilter();
        instance.doFilter(request, response, chain);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDestroy() {
        System.out.println("destroy");
        AuthorizationFilter instance = new AuthorizationFilter();
        instance.destroy();
        fail("The test case is a prototype.");
    }
    
}
