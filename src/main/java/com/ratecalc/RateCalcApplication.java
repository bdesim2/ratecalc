package com.ratecalc;

import com.ratecalc.controllers.RateController;
import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is the application config for the JavaX application.
 * This is a custom Application setup that will allow the setup of our beans
 *
 * JAX-RS-3.1 JAVAX is used for this REST application
 *
 * @Author Brian DeSimone
 * @Date 07/13/2018
 */
@ApplicationPath("/")
public class RateCalcApplication extends Application {

    public RateCalcApplication(){
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:80");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("com.ratecalculator");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        // add our endpoints
        classes.add(RateController.class);
        // enable swagger
        classes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        classes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        return classes;
    }

}
