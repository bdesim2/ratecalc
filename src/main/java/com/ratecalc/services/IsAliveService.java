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
    private static final Logger LOGGER = LogManager.getLogger(IsAliveService.class);
    private static final String TEMPLATE = "Hello, %s!: Rate Calculator is Alive!! WELCOME!!";
    private final transient AtomicLong counter = new AtomicLong();

    public HealthCheck getHealthCheck(String name){
        final HealthCheck healthCheck = new HealthCheck();
        healthCheck.setId(counter.incrementAndGet());
        healthCheck.setContent(String.format(TEMPLATE, name));
        return healthCheck;
    }
}
