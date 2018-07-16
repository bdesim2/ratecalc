package com.ratecalc.controllers;

import com.ratecalc.constants.Status;
import com.ratecalc.models.response.RatesResponse;
import org.apache.http.HttpStatus;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * Unit Tests for rate controller
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class TestRateController extends JerseyTest {

    @Override
    protected Application configure(){
        return new ResourceConfig(RateController.class);
    }

    @Test
    public void getAllRatesSuccess(){
        Response response = target("/rates").request().get();
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatus());
    }

    @Test
    public void getAllRatesSchema(){
        RatesResponse response = target("/rates").request().get(RatesResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.SUCCESS.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.SUCCESS.getStatusMessage(), response.getStatusMessage());
        Assert.assertTrue(response.getRates().size() > 0);
    }

}
