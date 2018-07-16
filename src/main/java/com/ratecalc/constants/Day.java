package com.ratecalc.constants;

/**
 * This enum holds the days of the week as represented in our parking_rates.json file
 *
 * @Author Brian DeSimone
 * @Author 07/14/2018
 */
public enum Day {

    MONDAY("mon", "MONDAY"),
    TUESDAY("tues", "TUESDAY"),
    WEDNESDAY("wed", "WEDNESDAY"),
    THURSDAY("thurs", "THURSDAY"),
    FRIDAY("fri", "FRIDAY"),
    SATURDAY("sat", "SATURDAY"),
    SUNDAY("sun", "SUNDAY");

    /**
     * Variable that holds the day abbreviation
     */
    private String day;

    /**
     * Variable that holds the full day
     */
    private String fullDay;

    Day(final String day, final String fullDay){
        this.day = day;
        this.fullDay = fullDay;
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

}
