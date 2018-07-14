package com.ratecalc;

import com.ratecalc.controllers.IsAliveController;
import com.ratecalc.controllers.RateController;
import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.jaxrs.config.BeanConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * This class is the application config for the JavaX application.
 * This is a custom Application setup that will allow the setup of our beans
 *
 * JAX-RS-2.1 JAVAX is used for this REST application
 *
 * @Author Brian DeSimone
 * @Date 07/13/2018
 */
@ApplicationPath("/")
@SwaggerDefinition(
        info = @Info(
                title = "Rate Calculator",
                version = "1.0.0",
                description = "The rate calculator micro-service will calculate a rate based on the day of the week," +
                    " start time, and end time desired.",
                contact = @Contact(
                        name = "Brian DeSimone",
                        email = "bdesim2@gmail.com"
                )
        )
)
public class RateCalcApplication extends Application {

    private final static Logger LOGGER = LogManager.getLogger(RateCalcApplication.class);

    public RateCalcApplication(){
        startApplication();
        startBeans();
    }

    // Let's get this show going... startup the app...
    public void startApplication(){
        LOGGER.info("Rate Calculator Initializing!!");
    }

    public void startBeans(){
        LOGGER.info("Beginning setup of the application... Initializing Swagger Documentation.");
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("com.ratecalc");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        // add our endpoints
        classes.add(RateController.class);
        classes.add(IsAliveController.class);
        // enable swagger
        classes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        classes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        return classes;
    }

}