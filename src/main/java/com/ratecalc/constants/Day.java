package com.ratecalc.constants;

import javax.ws.rs.NotFoundException;

/**
 * This enum holds the days of the week as represented in our parking_rates.json file
 *
 * @Author Brian DeSimone
 * @Author 07/14/2018
 */
public enum Day {

    SUNDAY("sun", "SUNDAY", 1),
    MONDAY("mon", "MONDAY", 2),
    TUESDAY("tues", "TUESDAY", 3),
    WEDNESDAY("wed", "WEDNESDAY", 4),
    THURSDAY("thurs", "THURSDAY", 5),
    FRIDAY("fri", "FRIDAY", 6),
    SATURDAY("sat", "SATURDAY", 7);

    /**
     * Variable that holds the day abbreviation
     */
    private String day;

    /**
     * Variable that holds the full day
     */
    private String fullDay;

    /**
     * Variable that holds the int value of a day
     */
    private int value;

    Day(final String day, final String fullDay, final int value){
        this.day = day;
        this.fullDay = fullDay;
        this.value = value;
    }

    /**
     * Take the abbreviation of a day and turn into the full day so we can use for parsing
     * @param abbreviation abbreviated day as found in our parking_rates.json
     * @return full day name
     */
    public static String convertToFullDay(String abbreviation){
        for (Day day : Day.values()){
            if (day.getDay().equalsIgnoreCase(abbreviation)){
                return day.getFullDay();
            }
        }
        throw new NotFoundException("Could not find a day of the week for: " + abbreviation);
    }

    /**
     * Method to convert the integer value of a day to the abbreviated representation from our config file
     * @param intValue
     * @return abbreviated day
     */
    public static String convertValueToAbbreviation(int intValue){
        for (Day day : Day.values()){
            if (day.getValue() == intValue){
                return day.getDay();
            }
        }
        throw new NotFoundException("Could not find a day of the week for int representation: " + intValue);
    }

    /**
     * Getter for the day abbreviation
     * @return day
     */
    String getDay(){
        return this.day;
    }

    /**
     * Getter for the full day
     * @return full day name
     */
    String getFullDay(){
        return this.fullDay;
    }

    /**
     * Getter for the int value of a day
     * @return int value of a day
     */
    public int getValue() {
        return value;
    }
}
