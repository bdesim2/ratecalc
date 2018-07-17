package com.ratecalc.models.rate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * This class will hold the converted rate for each day as parking rates. This is after we parse the json config
 * and turn the data into something we can use in our application
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingRate {

    @JsonProperty
    private String startTime;
    @JsonProperty
    private String endTime;
    @JsonProperty
    private int price;

    public ParkingRate(){

    }

    public ParkingRate(int price, String startTime, String endTime){
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Method to check two ISO times to see if they are represented in the parking rate
     */
    public boolean containsTimes(LocalDateTime begin, LocalDateTime end){
        int startHour = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("Hmm")).getHour();
        int endHour = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("Hmm")).getHour();
        if (startHour <= begin.getHour() && endHour >= end.getHour()){
            return true;
        }
        else {
            return false;
        }
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
