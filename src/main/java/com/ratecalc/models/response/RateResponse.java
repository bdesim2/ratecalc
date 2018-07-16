package com.ratecalc.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class represents the rate response object that is returned for the
 * GET and POST response on the /rate controllers
 *
 * @Author Brian DeSimone
 * @Date 07/14/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RateResponse {

    @XmlElement
    @JsonProperty
    @ApiModelProperty(required = true)
    private Long timestamp;

    @XmlElement
    @JsonProperty
    @ApiModelProperty(required = true)
    private int statusCode;

    @XmlElement
    @JsonProperty
    @ApiModelProperty(required = true)
    private String statusMessage;

    @XmlElement
    @JsonProperty
    @ApiModelProperty(required = true)
    private int rate;

    public RateResponse(int statusCode, String statusMessage, int rate){
        this.timestamp = System.currentTimeMillis();
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.rate = rate;
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

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
