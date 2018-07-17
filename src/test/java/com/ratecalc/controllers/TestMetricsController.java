package com.ratecalc.controllers;

import com.ratecalc.exception.InternalServerExceptionMapper;
import org.apache.http.HttpStatus;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * Unit tests for metrics controller
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class TestMetricsController extends JerseyTest {

    @Override
    protected Application configure(){
        return new ResourceConfig(RateController.class, MetricsController.class, InternalServerExceptionMapper.class);
    }

    // ================================================================================================================
    // GET RESPONSE TIME TESTS
    // ================================================================================================================

    @Test
    public void testGetResponseTimes(){
        Response response = target("/metrics/responseTimes").request().get();
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatus());
    }

}
