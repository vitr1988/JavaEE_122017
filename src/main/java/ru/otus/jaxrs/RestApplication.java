package ru.otus.jaxrs;

import ru.otus.jaxrs.async.CabBookingResource;
import ru.otus.jaxrs.async.ReportResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {

//    private static final String RESOURCE_PACKAGE = UsersResource.class.getPackage().getName();

    public RestApplication(){
//        BeanConfig beanConfig = new BeanConfig();
//        beanConfig.setTitle("Swagger JAX-RS Integration Example");
//        beanConfig.setDescription("A simple Maven Glassfish JAX-RS project.");
//        beanConfig.setVersion("1.0.0");
//        beanConfig.setSchemes(new String[]{"http"});
//        beanConfig.setHost("localhost:8080");
//        beanConfig.setBasePath("/JavaEE/api");
//        beanConfig.setResourcePackage(RESOURCE_PACKAGE);
//        beanConfig.setPrettyPrint(true);
//        beanConfig.setScan(true);
    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);

        // enable Swagger
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(RestfulCalculator.class);
        resources.add(UsersResource.class);
        resources.add(CabBookingResource.class);
        resources.add(ReportResource.class);
    }
}
