package com.ratecalc.config;

import com.ratecalc.models.rate.ParkingRate;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit tests for rate config
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class TestRateConfig {

    // GLOBAL CLASS VARIABLES
    private static final String PARKING_RATES = "/parking_rates.json";

    /**
     * Test that the parking_rates.json file populates data into the config
     * IE: should not be empty
     */
    @Test
    public void testReadConfig(){
        RateConfig rateConfig = new RateConfig(RateConfig.class.getResource(PARKING_RATES));
        Assert.assertNotEquals(new HashMap<>(), rateConfig.getParkingRates());
    }

    /**
     * Test that the parking rate json file can be read in and converted to our ParkingRates pojo
     */
    @Test
    public void getParkingRates(){
        Map<String, List<ParkingRate>> parkingRates = RateConfig.getInstance().getParkingRates();
        Assert.assertNotEquals(new HashMap<>(), parkingRates);
    }

    /**
     * Test that the app does not startup and the proper exception is thrown if config file is not present.
     */
    @Test(expected = NullPointerException.class)
    public void testNoFile(){
        new RateConfig(RateConfig.class.getResource("INVALID"));
        // Auto assert expected exception was thrown
    }

    /**
     * TODO: Test that the app does not start up if the config file is not in json format.
     */
    @Test
    public void testInvalidJson(){

    }

}
