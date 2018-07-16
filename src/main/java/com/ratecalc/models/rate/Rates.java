package com.ratecalc.models.rate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that will read in the total rates and sort in a list of 'Rate' from our parking_rates.json
 *
 * @Author Brian DeSimone
 * @Date 07/14/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rates {

    @JsonProperty
    private List<Rate> rates = new ArrayList<>();

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
