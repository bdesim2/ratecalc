package com.ratecalc.constants;

/**
 * This enum is status that holds all status codes and status messages. Positive and negative codes and messages
 *
 * @Author Brian DeSimone
 * @Date 07/14/2018
 */
public enum Status {

    SUCCESS(200, "Success"),
    UPDATED(200, "Updated"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NO_CONTENT(204, "No Content"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    CONFLICT(409, "Conflict"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout");

    /**
     * Variable that holds the status code
     */
    private int code;

    /**
     * Variable that holds the status message
     */
    private String message;

    Status(final int code, final String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Getter for status code
     * @return code
     */
    public int getStatusCode(){
        return code;
    }

    /**
     * Getter for status message
     * @return message
     */
    public String getStatusMessage(){
        return message;
    }
}
