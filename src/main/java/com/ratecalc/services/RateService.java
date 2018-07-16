package com.ratecalc.services;

import com.ratecalc.config.RateConfig;
import com.ratecalc.models.exceptions.InvalidRateRangeException;
import com.ratecalc.models.exceptions.ServerException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
     * @return the rate for the range
     * @throws ServerException - application exception... has many extensions for this application
     */
    public int calculateRate(String startTime, String endTime) throws ServerException {
        // check start and end time are in ISO format
//        checkFormat(startTime);
//        checkFormat(endTime);
        //




        // stub this for now
        return 100;
    }

    public void checkFormat(String dateTime) throws InvalidRateRangeException {
        // try to parse the dateTime with the JAVA LocalDateTime Formatter... if parse exception throw our exception
        try {
            LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
        }
        catch (DateTimeParseException ex){
            LOGGER.info("Invalid ISO date time entered for startRate or endRate. Please check the date/time: " + dateTime);
            throw new InvalidRateRangeException(dateTime);
        }
    }

}
