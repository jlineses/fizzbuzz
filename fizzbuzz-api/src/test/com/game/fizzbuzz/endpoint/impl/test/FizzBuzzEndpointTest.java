package com.game.fizzbuzz.endpoint.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.game.fizzbuzz.config.JerseyConfig;
import com.game.fizzbuzz.config.SpringConfig;


public class FizzBuzzEndpointTest extends JerseyTest {


    @Override
    public Application configure() {

        // configure spring context
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();

        // configure Jersey app
        MockServletContext mockServletContext = new MockServletContext();
        mockServletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);

        JerseyConfig config = new JerseyConfig(mockServletContext);
        config.property("contextConfig", context); // from SpringComponentProvider.PARAM_SPRING_CONTEXT="contextConfig"
        return config;
    }
    
    @Test
    public void testDoFizzBuzz() {
        Response response = target("game/1").request().get();
        assertNotNull(response.getEntity());
        assertTrue(response.hasEntity());
        assertEquals(200, response.getStatus());
        response.close();
    }
}
