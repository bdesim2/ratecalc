package com.ratecalc.services;

import com.ratecalc.config.RateConfig;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * This service holds all operations for calculating rates.
 *
 * @Author Brian DeSimone
 * @Date 07/15/2018
 */
public class RateService {

    // GLOBAL CLASS VARIABLES
    private static final Logger LOGGER = LogManager.getLogger(RateService.class);
    private RateConfig rateConfig = RateConfig.getInstance();

    public int calculateRate(String startTime, String endTime){
        return 100;
    }

}
