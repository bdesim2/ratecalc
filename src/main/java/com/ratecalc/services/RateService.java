package com.ratecalc.services;

import com.ratecalc.config.RateConfig;
import com.ratecalc.constants.Day;
import com.ratecalc.models.exceptions.InvalidRateRangeException;
import com.ratecalc.models.exceptions.InvalidTimeOrderException;
import com.ratecalc.models.exceptions.ServerException;
import com.ratecalc.models.exceptions.TimeInPastException;
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
        // Make sure that the end time is after the start time.. and the start time and end time are not in the past or anything funky like that
//        validateDateTimeNotInPast(startTime);
//        validateDateTimeNotInPast(endTime);
//        validateEndTimeAfterStartTime(startTime, endTime);
        // find our actual rate now that we know our input is valid
        return findParkingRate(startTime, endTime);
        // stub this for now
//        return 100;
    }

    /**
     * Method to check the format of the time
     * @param dateTime input from user
     * @throws InvalidRateRangeException - thrown if not in ISO format
     */
    private void checkFormat(String dateTime) throws InvalidRateRangeException {
        // try to parse the dateTime with the JAVA LocalDateTime Formatter... if parse exception throw our exception
        try {
            LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
        }
        catch (DateTimeParseException ex){
            LOGGER.info("Invalid ISO date time entered for startRate or endRate. Please check the date/time: " + dateTime);
            throw new InvalidRateRangeException(dateTime);
        }
    }

    /**
     * Method to validate that the rateEnd time is after the startRate time
     * @param startTime user start time input
     * @param endTime user end time input
     * @throws InvalidTimeOrderException - thrown if startRate time after endRate time
     */
    private void validateEndTimeAfterStartTime(String startTime, String endTime) throws InvalidTimeOrderException {
        LocalDateTime begin = LocalDateTime.parse(startTime, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime end = LocalDateTime.parse(endTime, DateTimeFormatter.ISO_DATE_TIME);
        if (end.isBefore(begin)){
            throw new InvalidTimeOrderException();
        }
    }

    /**
     * Method to check user input ISO times to make sure they are > present
     * @param dateTime user ISO input
     * @throws TimeInPastException - thrown if the date/time is in the past
     */
    private void validateDateTimeNotInPast(String dateTime) throws TimeInPastException {
        LocalDateTime time = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
        if (time.isBefore(LocalDateTime.now())){
            throw new TimeInPastException(time.toString());
        }
    }

    /**
     * THIS IS WHAT ACTUALLY CALCULATES THE RATE!!!!!!!!
     * If we get here that means we got past all of the exceptions and we are ready to calculate the rate if it exists
     * @param startTime user start time input
     * @param endTime user end time input
     * @return integer value of the rate
     */
    private int findParkingRate(String startTime, String endTime){
        LocalDateTime begin = LocalDateTime.parse(startTime, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime end = LocalDateTime.parse(endTime, DateTimeFormatter.ISO_DATE_TIME);
        int dayOfWeek = begin.getDayOfWeek().getValue();
        LOGGER.info("Testing day of week: " + Day.convertValueToAbbreviation(dayOfWeek));
        return 100;
    }

}
