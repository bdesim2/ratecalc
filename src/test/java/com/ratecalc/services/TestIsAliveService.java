package com.ratecalc.services;

import com.ratecalc.models.HealthCheck;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Unit tests for isAlive service
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class TestIsAliveService {

    // GLOBAL CLASS VARIABLES
    private IsAliveService isAliveService = new IsAliveService();
    private static final String TEMPLATE = "Hello, %s!: Rate Calculator is Alive!! WELCOME!!";

    @Test
    public void testGetHealthCheck(){
        String name = "Brian DeSimone";
        AtomicLong counter = new AtomicLong();
        HealthCheck healthCheck = isAliveService.getHealthCheck(name, counter);
        Assert.assertEquals(1, healthCheck.getId());
        Assert.assertEquals(String.format(TEMPLATE, name), healthCheck.getContent());
    }

}
