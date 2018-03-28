package com.game.fizzbuzz.config;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.game.fizzbuzz.endpoint.IFizzBuzzEndpoint;
import com.game.fizzbuzz.service.IFizzBuzzService;


@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(@Context ServletContext context) {
        WebApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(context);

        register(appCtx.getBean(IFizzBuzzEndpoint.class));
        register(appCtx.getBean(IFizzBuzzService.class));
    }
}

