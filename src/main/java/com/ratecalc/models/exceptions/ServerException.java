package com.ratecalc.models.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;

/**
 * Server exception. Base for our application
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerException extends Exception {

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
    private int errorCode;

    @XmlElement
    @JsonProperty
    @ApiModelProperty(required = true)
    private String errorMessage;

    public ServerException(){

    }

    public ServerException(int statusCode, String statusMessage, int errorCode, String errorMessage) {
        this.timestamp = System.currentTimeMillis();
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
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

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
