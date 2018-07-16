package com.ratecalc.constants;

/**
 * This enum is where we will hold all error codes and error messages.
 *
 * @Author Brian DeSimone
 * @Date 07/14/2018
 */
public enum Error {

    INTERNAL_SERVER_ERROR(1001, "Failed to process the request."),
    INVALID_JSON(1002, "The JSON body is invalid in the request."),
    INVALID_REQUIRED(1003, "One or more request attributes is missing, invalid, or not following constraints."),
    INVALID_RATE_TIME(1004, "startRate and endRate must be in ISO DateTime format and is a required field."),
    INVALID_TIME_ORDER(1005, "The \"endRate\" is sooner than the \"startRate\""),
    NO_RATE_FOUND(1006, "We could not find a rate for the given startRate - endRate");

    /**
     * Variable that holds the error code
     */
    private int code;

    /**
     * Variable that holds the error message
     */
    private String message;

    Error(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Getter for error code
     * @return code
     */
    public int getErrorCode(){
        return code;
    }

    /**
     * Getter for error message
     * @return message
     */
    public String getErrorMessage(){
        return message;
    }
}
