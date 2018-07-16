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

    /**
     * Calculate the rate for given start and end time. This method will handle all exceptions
     * @param startTime - user input start time in ISO format
     * @param endTime - user input end time in ISO format
     * @return
     * @throws
     */
    public int calculateRate(String startTime, String endTime){
        return 100;
    }

}
