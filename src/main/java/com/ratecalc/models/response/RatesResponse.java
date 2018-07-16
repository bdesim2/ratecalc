package com.ratecalc.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ratecalc.models.rate.ParkingRate;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * This class will hold the pojo for the get all rates response
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RatesResponse {

    @JsonProperty
    @ApiModelProperty(required = true)
    private Long timestamp;

    @JsonProperty
    @ApiModelProperty(required = true)
    private int statusCode;

    @JsonProperty
    @ApiModelProperty(required = true)
    private String statusMessage;

    @JsonProperty
    @ApiModelProperty(required = true)
    private Map<String, List<ParkingRate>> rates = null;

    public RatesResponse(int statusCode, String statusMessage, Map<String, List<ParkingRate>> rates){
        this.timestamp = System.currentTimeMillis();
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.rates = rates;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Map<String, List<ParkingRate>> getRates() {
        return rates;
    }

    public void setRates(Map<String, List<ParkingRate>> rates) {
        this.rates = rates;
    }
}
