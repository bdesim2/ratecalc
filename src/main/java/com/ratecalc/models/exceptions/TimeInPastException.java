package com.ratecalc.models.exceptions;

import com.ratecalc.constants.Error;
import com.ratecalc.constants.Status;

/**
 * ServerException extension for when a time is in the past for calculating the parking rate
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class TimeInPastException extends ServerException {

    public TimeInPastException(String dateTime){
        super(
                Status.BAD_REQUEST.getStatusCode(),
                Status.BAD_REQUEST.getStatusMessage(),
                Error.PAST_START_TIME.getErrorCode(),
                Error.PAST_START_TIME.getErrorMessage() + " Value: " + dateTime
        );
    }
}
