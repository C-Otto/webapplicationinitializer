package com.example.pack;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class ContextListener implements ServletContextListener {

    private ContextLoaderListener wrappedListener;

    public ContextListener() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.registerShutdownHook();
        context.refresh();
        wrappedListener = new ContextLoaderListener(context);
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        wrappedListener.contextInitialized(event);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        wrappedListener.contextDestroyed(event);
    }
}
