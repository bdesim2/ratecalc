package com.ratecalc.models.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    @XmlElement(name = "startRate")
    @JsonProperty(value = "startRate")
    @ApiModelProperty(required = true)
    @NotNull(message = "startRate cannot be null. This is a required field.")
    private String startRate;

    @XmlElement(name = "endRate")
    @JsonProperty(value = "endRate")
    @ApiModelProperty(required = true)
    @NotNull(message = "endRate cannot be null. This is a required field.")
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
