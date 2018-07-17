package com.ratecalc.controllers;

import com.ratecalc.constants.Error;
import com.ratecalc.constants.Status;
import com.ratecalc.exception.InternalServerExceptionMapper;
import com.ratecalc.models.exceptions.ServerErrorResponse;
import com.ratecalc.models.request.RateRequest;
import com.ratecalc.models.response.RateResponse;
import com.ratecalc.models.response.RatesResponse;
import org.apache.http.HttpStatus;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
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
        return new ResourceConfig(RateController.class, InternalServerExceptionMapper.class);
    }

    // ================================================================================================================
    // GET ALL RATES TESTS
    // ================================================================================================================

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

    // ================================================================================================================
    // GET RATE TESTS
    // ================================================================================================================

    @Test
    public void getRateSuccess() {
        Response response = target("/rate/2019-07-15T09:00:00Z/2019-07-15T21:00:00Z").request().get();
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatus());
    }

    @Test
    public void getRateSchema(){
        RateResponse response = target("/rate/2019-07-15T09:00:00Z/2019-07-15T21:00:00Z").request().get(RateResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.SUCCESS.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.SUCCESS.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(2000, response.getRate());
    }

    @Test
    public void getRateSunday(){
        RateResponse response = target("/rate/2019-07-15T10:00:00Z/2019-07-15T20:00:00Z").request().get(RateResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.SUCCESS.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.SUCCESS.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(2000, response.getRate());
    }

    @Test
    public void getRateMonday(){
        RateResponse response = target("/rate/2019-07-16T02:00:00Z/2019-07-16T04:00:00Z").request().get(RateResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.SUCCESS.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.SUCCESS.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(1000, response.getRate());
    }

    @Test
    public void getRateTuesday(){
        RateResponse response = target("/rate/2019-07-17T10:00:00Z/2019-07-17T12:00:00Z").request().get(RateResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.SUCCESS.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.SUCCESS.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(1500, response.getRate());
    }

    @Test
    public void getRateWednesday(){
        RateResponse response = target("/rate/2019-07-18T06:00:00Z/2019-07-18T18:00:00Z").request().get(RateResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.SUCCESS.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.SUCCESS.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(1750, response.getRate());
    }

    @Test
    public void getRateThursday(){
        RateResponse response = target("/rate/2019-07-19T09:00:00Z/2019-07-19T21:00:00Z").request().get(RateResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.SUCCESS.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.SUCCESS.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(1500, response.getRate());
    }

    @Test
    public void getRateFriday(){
        RateResponse response = target("/rate/2019-07-20T09:00:00Z/2019-07-20T21:00:00Z").request().get(RateResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.SUCCESS.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.SUCCESS.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(2000, response.getRate());
    }

    @Test
    public void getRateSaturday(){
        RateResponse response = target("/rate/2019-07-20T15:00:00Z/2019-07-20T16:00:00Z").request().get(RateResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.SUCCESS.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.SUCCESS.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(2000, response.getRate());
    }

    @Test(expected = NotFoundException.class)
    public void getUnavailableRate() {
        ServerErrorResponse response = target("/rate/2019-07-15T01:00:00Z/2019-07-15T23:00:00Z").request().get(ServerErrorResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.NOT_FOUND.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(Error.NO_RATE_FOUND.getErrorCode(), response.getErrorCode());
        Assert.assertEquals(Error.NO_RATE_FOUND.getErrorMessage(), response.getErrorMessage());
    }

    @Test(expected = BadRequestException.class)
    public void testInvalidISOTime(){
        ServerErrorResponse response = target("/rate/2019-07/2019-07").request().get(ServerErrorResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.BAD_REQUEST.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(Error.INVALID_RATE_TIME.getErrorCode(), response.getErrorCode());
        Assert.assertEquals(Error.INVALID_RATE_TIME.getErrorMessage(), response.getErrorMessage());
    }

    @Test(expected = BadRequestException.class)
    public void testInvalidEndTimeBeforeStartTime(){
        ServerErrorResponse response = target("/rate/2019-07-20T01:00:00Z/2019-07-15T23:00:00Z").request().get(ServerErrorResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.BAD_REQUEST.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(Error.INVALID_TIME_ORDER.getErrorCode(), response.getErrorCode());
        Assert.assertEquals(Error.INVALID_TIME_ORDER.getErrorMessage(), response.getErrorMessage());
    }

    // TODO: This feature is shut off for now
//    @Test(expected = TimeInPastException.class)
//    public void testTimeInPast(){
//        target("/rate/2015-07-20T01:00:00Z/2015-07-15T23:00:00Z").request().get();
//        // auto assert, expected exception thrown
//    }

    // ================================================================================================================
    // POST RATE TESTS
    // Only testing valid and invalid rate ranges since we tested all days for the GET API
    // ================================================================================================================

    @Test
    public void testPostRateSuccess(){
        Response response = target("/rate").request().post(Entity.entity(new RateRequest("2019-07-15T09:00:00Z", "2019-07-15T21:00:00Z"), MediaType.APPLICATION_JSON));
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatus());
    }

    @Test
    public void testPostRateSchema(){
        RateResponse response = target("/rate").request().post(Entity.entity(new RateRequest("2019-07-15T09:00:00Z", "2019-07-15T21:00:00Z"), MediaType.APPLICATION_JSON), RateResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.SUCCESS.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.SUCCESS.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(2000, response.getRate());
    }

    @Test(expected = BadRequestException.class)
    public void testPostInvalidJson(){
        target("/rate").request().post(Entity.entity("INVALID", MediaType.APPLICATION_JSON), ServerErrorResponse.class);
        // auto assert, expected exception thrown
    }

    @Test(expected = BadRequestException.class)
    public void testRequiredAttributes(){
        ServerErrorResponse response = target("/rate").request().post(Entity.entity(new RateRequest("", "2019-07-15T21:00:00Z"), MediaType.APPLICATION_JSON), ServerErrorResponse.class);
        Assert.assertNotNull(response.getTimestamp());
        Assert.assertEquals(Status.BAD_REQUEST.getStatusCode(), response.getStatusCode());
        Assert.assertEquals(Status.BAD_REQUEST.getStatusMessage(), response.getStatusMessage());
        Assert.assertEquals(Error.INVALID_REQUIRED.getErrorCode(), response.getErrorCode());
        Assert.assertEquals(Error.INVALID_REQUIRED.getErrorMessage(), response.getErrorMessage());
    }

}
