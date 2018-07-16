package com.ratecalc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ratecalc.constants.Day;
import com.ratecalc.core.Common;
import com.ratecalc.models.rate.ParkingRate;
import com.ratecalc.models.rate.Rate;
import com.ratecalc.models.rate.Rates;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class will read in the config for our rate converter. This config is based on the rates json file provided for
 * this exercise. This class will read in this config and store these rates for use in calculating parking prices.
 *
 * CREDITS: SOME OF THIS CLASS WAS BORROWED FROM COMMON LIBRARIES I WROTE IN PAST PROJECTS FOR READING IN JSON CONFIG FILES
 *
 * @Author Brian DeSimone
 * @Date 07/14/2018
 */
public class RateConfig {

    // GLOBAL CLASS VARIABLES
    private static final Logger LOGGER = LogManager.getLogger(RateConfig.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static Common common = new Common();
    private static RateConfig ourInstance;
    private static final String PARKING_RATES = "/parking_rates.json";

    // VARIABLE TO HOLD THE TRANSFORMED DATA
    private transient Map<String, List<ParkingRate>> parkingRates = new HashMap<>();

    /**
     * Generic constructor that will read in config files from path.. for our application read in parking rates json
     */
    public RateConfig(URL fileName) {
        LOGGER.info("Reading in config files from path: " + fileName.getPath());
        // Read in our parking_rate config json file
        try {
            populateParkingRates(fileName.getPath());
        }
        catch(Exception ex){
            LOGGER.error("Could not read parking rates config file. ERROR: " + ex);
        }
    }

    public static RateConfig getInstance() {
        if (ourInstance == null) {
            ourInstance = new RateConfig(RateConfig.class.getResource(PARKING_RATES));
        }
        return ourInstance;
    }

    /**
     * Read in parking rates json file and place the data in a readable class
     * @param filePath to json file of parking rates
     */
    private void populateParkingRates(String filePath) throws IOException, IllegalAccessException, InstantiationException {
        final Rates rates = readJSONFile(filePath, Rates.class);
        LOGGER.info("We have successfully read the JSON config file. Parking Rates from config:");
        common.logObject(rates);
        LOGGER.info("Transforming the parking rates from the config to a map of {<Day>, [<ParkingRates>]}");
        convertRate(rates);
    }

    /**
     * Read in the JSON config file based on the file path. If exists turn that config file into a pojo based on the
     * object class specified
     * @param filePath path to json config
     * @param c destination object class
     * @param <T> abstract method to object class
     * @return return the object of the config
     */
    private <T> T readJSONFile(final String filePath, final Class<T> c) throws IOException, IllegalAccessException, InstantiationException {
        File file = new File(filePath);
        // if file exists read it in and map it to object with jackson
        if (file.exists()){
            return objectMapper.readValue(file, c);
        }
        else {
            LOGGER.error("Could not find json config file at path: " + filePath + " for class: " + c.getName());
            LOGGER.warn("Initializing new object for: " + c.getName());
        }
        // create a new object of type <T>
        return c.newInstance();
    }

    /**
     * Method to convert the json parking rates file to a pojo that holds days and each parking rate per given time
     * @param rates Rates object from config json file
     * @return Map of days and parking rates
     */
    private void convertRate(Rates rates){
        // go through each rate and add the rate to the appropriate day in the map
        for (Rate rate:rates.getRates()){
            parseParkingRate(rate);
        }
    }

    /**
     * MAIN PARSER! This method will do the dirty work and parse out the config file and actually populate our ParkingRates object
     * @param rate each rate to populate from the config
     */
    private void parseParkingRate(Rate rate){
        // First we need to get our days from each rate in the config file and store as an array we can use later
        String[] days = rate.getDays().split(",");
        // for each day make sure we grab the rate, make a list, and populate the parkingRates map by day
        for (String day:days){
            // split out the start and end time
            String[] times = rate.getTimes().split("-");
            ParkingRate parkingRate = new ParkingRate(
                    rate.getPrice(),
                    times[0],
                    times[1]
            );
            // Make a list of parking rates by day from the parking rates found so far... If no rates exist default to empty list
            List<ParkingRate> rateList = this.parkingRates.getOrDefault(day, new ArrayList<>());
            rateList.add(parkingRate);
            // Lastly put the rate list in the parking rates pojo by day
            parkingRates.put(day, rateList);
        }

    }

    // GETTER
    public Map<String, List<ParkingRate>> getParkingRates() {
        return parkingRates;
    }
}
