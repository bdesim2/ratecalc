package com.ratecalc.models.exceptions;

/**
 * Server exception. Base for our application
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class ServerException extends Exception {

    private Long timestamp;
    private int statusCode;
    private String statusMessage;
    private int errorCode;
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
