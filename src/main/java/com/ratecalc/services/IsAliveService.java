package com.ratecalc.services;

import com.ratecalc.models.HealthCheck;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicLong;

/**
 * This service will run the isAlive controller and all operations
 *
 * @Author Brian DeSimone
 * @Date 07/14/2018
 */
public class IsAliveService {

    // GLOBAL CLASS VARIABLES
    private static final String TEMPLATE = "Hello, %s!: Rate Calculator is Alive!! WELCOME!!";

    /**
     * create a new healthcheck response
     * @param name name to say hello to
     * @param counter atomic counter that increments with each GET
     * @return the healcheck response
     */
    public HealthCheck getHealthCheck(final String name, final AtomicLong counter){
        final HealthCheck healthCheck = new HealthCheck();
        healthCheck.setId(counter.incrementAndGet());
        healthCheck.setContent(String.format(TEMPLATE, name));
        return healthCheck;
    }
}
