package com.ratecalc.models.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class will represent the pojo for rate requests
 * Two parameters will be used here for JSON and XML requests
 * startRate and endRate
 *
 * @Author Brian DeSimone
 * @Date 07/14/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name = "rate")
@XmlAccessorType(XmlAccessType.FIELD)
public class RateRequest {

    @XmlElement(name = "start")
    @JsonProperty(value = "start")
    private String startRate;

    @XmlElement(name = "end")
    @JsonProperty(value = "end")
    private String endRate;

    public RateRequest(){

    }

    public String getStartRate() {
        return startRate;
    }

    public void setStartRate(String startRate) {
        this.startRate = startRate;
    }

    public String getEndRate() {
        return endRate;
    }

    public void setEndRate(String endRate) {
        this.endRate = endRate;
    }
}
