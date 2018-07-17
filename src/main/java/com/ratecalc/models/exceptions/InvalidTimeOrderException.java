package com.ratecalc.models.exceptions;

import com.ratecalc.constants.Error;
import com.ratecalc.constants.Status;

/**
 * ServerException extension for when the endRate is before the startRate
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class InvalidTimeOrderException extends ServerException {

    public InvalidTimeOrderException(){
        super(
                Status.BAD_REQUEST.getStatusCode(),
                Status.BAD_REQUEST.getStatusMessage(),
                Error.INVALID_TIME_ORDER.getErrorCode(),
                Error.INVALID_TIME_ORDER.getErrorMessage()
        );
    }

}
