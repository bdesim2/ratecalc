package com.ratecalc.models.rate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to create the pojo from our parking_rates.json
 *
 * @Author Brian DeSimone
 * @Date 07/14/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {

    @JsonProperty
    private String days;
    @JsonProperty
    private String times;
    @JsonProperty
    private int price;

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
