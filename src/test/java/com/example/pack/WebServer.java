package com.example.pack;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.junit.rules.ExternalResource;

class WebServer extends ExternalResource {

    private static final String BASE_DIRECTORY = "embedded_tomcat"; // contains temporary files
    private static final int USE_FREE_PORT = 0;
    private static final String CONTEXT_PATH = ""; // root (/)
    private Tomcat tomcat;

    @Override
    protected void before() throws Throwable {
        startEmbeddedTomcat();
    }

    @Override
    protected void after() {
        try {
            tomcat.stop();
            tomcat.destroy();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }

    private void startEmbeddedTomcat() throws ServletException, LifecycleException {
        String pathToWebXML = new File("src/main/webapp/").getAbsolutePath();

        tomcat = new Tomcat();
        tomcat.setBaseDir(BASE_DIRECTORY);
        tomcat.setPort(USE_FREE_PORT);
        tomcat.addWebapp(CONTEXT_PATH, pathToWebXML);
        tomcat.start();
    }
}