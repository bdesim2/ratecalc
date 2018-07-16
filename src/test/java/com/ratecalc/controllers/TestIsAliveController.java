package com.ratecalc.controllers;

import com.ratecalc.models.HealthCheck;
import org.apache.http.HttpStatus;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * Unit tests for isAlive controller
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class TestIsAliveController extends JerseyTest {

    @Override
    protected Application configure(){
        return new ResourceConfig(IsAliveController.class);
    }

    @Test
    public void getIsAliveSuccess(){
        Response response = target("isAlive").request().get();
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatus());
    }

    @Test
    public void getIsAliveDefaultName(){
        HealthCheck response = target("isAlive").request().get(HealthCheck.class);
        Assert.assertEquals("Hello, World!: Rate Calculator is Alive!! WELCOME!!", response.getContent());
    }

    @Test
    public void getIsAliveName(){
        HealthCheck response = target("isAlive").queryParam("name", "Brian").request().get(HealthCheck.class);
        Assert.assertEquals("Hello, Brian!: Rate Calculator is Alive!! WELCOME!!", response.getContent());
    }

    @Test
    public void getIsAliveId(){
        HealthCheck response = target("isAlive").request().get(HealthCheck.class);
        Assert.assertEquals(1, response.getId());
    }


}
