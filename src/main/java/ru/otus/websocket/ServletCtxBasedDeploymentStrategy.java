package ru.otus.websocket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.websocket.server.ServerContainer;
import javax.websocket.server.ServerEndpointConfig;

@WebListener
public class ServletCtxBasedDeploymentStrategy implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce){
        //obtain the instance
        ServerContainer sc = (ServerContainer) sce.getServletContext().getAttribute("javax.websocket.server.ServerContainer");

        //trigger endpoint deployment
        deployAnnotatedEndpoint(sc);
        deployProgEndpoint(sc);
    }

    private void deployAnnotatedEndpoint(ServerContainer container) {
//        container.addEndpoint(StockTicker.class);
//        container.addEndpoint(WeatherTracker.class);
    }

    private void deployProgEndpoint(ServerContainer container) {
//        container.addEndpoint(ServerEndpointConfig.Builder.create(ChatClub.class, "/chatclub").build());
//        container.addEndpoint(ServerEndpointConfig.Builder.create(RealTimeLocationTracker.class, "/location").build());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){}
}
