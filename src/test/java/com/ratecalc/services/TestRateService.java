package com.ratecalc.services;

import com.ratecalc.models.exceptions.*;
import com.ratecalc.models.request.RateRequest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for rate service
 *
 * @Author Brian DeSimone
 * @Date 07/17/2018
 */
public class TestRateService {

    // GLOBAL CLASS VARIABLES
    private RateService rateService = new RateService();

    // VARIABLES FOR TESTS
    private String validStartDate = "2019-07-17T09:00:00Z";
    private String validEndDate = "2019-07-17T21:00:00Z";

    @Test
    public void testCheckRequiredFields() throws ServerException {
        RateRequest rateRequest = new RateRequest("2018-07-17T09:00:00Z", "2018-07-17T21:00:00Z");
        rateService.checkRequiredFields(rateRequest);
    }

    @Test(expected = RequiredAttributeException.class)
    public void testMissingRequiredFields() throws ServerException {
        RateRequest rateRequest = new RateRequest("", null);
        rateService.checkRequiredFields(rateRequest);
        // auto assert exception
    }

    @Test
    public void testCalculateRateValid() throws ServerException {
        Assert.assertEquals(1500, rateService.calculateRate(validStartDate, validEndDate));
    }

    @Test(expected = RateNotFoundException.class)
    public void testCalculateRateNotFound() throws ServerException{
        rateService.calculateRate("2018-07-17T09:00:00Z", "2018-07-17T23:00:00Z");
        // auto assert exception
    }

    @Test(expected = InvalidRateRangeException.class)
    public void testCalculateRateInvalidISODateTime() throws ServerException{
        rateService.calculateRate("2018-07-17", "2018-07-17");
        // auto assert exception
    }

    @Test(expected = InvalidTimeOrderException.class)
    public void testCalculateRateEndBeforeStart() throws ServerException{
        rateService.calculateRate("2018-07-17T09:00:00Z", "2018-07-10T10:00:00Z");
        // auto assert exception
    }

    // TODO: This feature is not yet in place
//    @Test(expected = TimeInPastException.class)
//    public void testCalculateRateTimeInPast() throws ServerException{
//        rateService.calculateRate("2010-07-17T09:00:00Z", "2010-07-10T10:00:00Z");
//        // auto assert exception
//    }

}
