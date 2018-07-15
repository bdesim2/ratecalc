package com.ratecalc.constants;

/**
 * This enum holds the days of the week as represented in our parking_rates.json file
 *
 * @Author Brian DeSimone
 * @Author 07/14/2018
 */
public enum Day {

    MONDAY("mon"),
    TUESDAY("tues"),
    WEDNESDAY("wed"),
    THURSDAY("thurs"),
    FRIDAY("fri"),
    SATURDAY("sat"),
    SUNDAY("sun");

    /**
     * Variable that holds the day abbreviation
     */
    private String day;

    Day(final String day){
        this.day = day;
    }

    /**
     * Getter for the day abbreviation
     * @return day
     */
    String getDay(){
        return this.day;
    }

}
