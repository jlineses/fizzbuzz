package com.game.fizzbuzz.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        registerContextLoaderListener(servletContext);
        servletContext.setInitParameter("contextConfigLocation", "");
    }
    
    private void registerContextLoaderListener(ServletContext servletContext) {
        WebApplicationContext webContext = createWebAplicationContext(SpringConfig.class);
        servletContext.addListener(new ContextLoaderListener(webContext));
    }
    
    public WebApplicationContext createWebAplicationContext(Class configClasses) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(configClasses);
        return context;
    }

}