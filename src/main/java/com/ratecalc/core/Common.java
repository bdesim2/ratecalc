package com.ratecalc.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * This class will hold common functions that can be used throughout the project
 *
 * @Author Brian DeSimone
 * @Date 07/14/2018
 */
public class Common {

    // GLOBAL CLASS VARIABLES
    private static final Logger LOGGER = LogManager.getLogger(Common.class);

    /**
     * Method to log POJOS to the log file and console
     * @param rawObject reads in a raw pojo
     */
    public void logObject(Object rawObject){
        try {
            ObjectMapper mapper = new ObjectMapper();
            LOGGER.info("Logging object: " + mapper.writeValueAsString(rawObject));
        }
        catch (JsonProcessingException ex){
            LOGGER.error("Could not parse object: " + ex);
        }
    }

}
