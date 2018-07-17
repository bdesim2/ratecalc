package com.ratecalc.models.exceptions;

import com.ratecalc.constants.Error;
import com.ratecalc.constants.Status;

/**
 * ServerException extension for when a rate start and end time range is invalid in any way
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class InvalidRateRangeException extends ServerException {

    public InvalidRateRangeException(String dateTime){
        super(
                Status.BAD_REQUEST.getStatusCode(),
                Status.BAD_REQUEST.getStatusMessage(),
                Error.INVALID_RATE_TIME.getErrorCode(),
                Error.INVALID_RATE_TIME.getErrorMessage() + " Value: " + dateTime
        );
    }

}
