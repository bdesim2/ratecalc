package com.ratecalc.models.exceptions;

import com.ratecalc.constants.Error;
import com.ratecalc.constants.Status;

/**
 * ServerException extension for when we cannot find a rate for a given start and end time
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class RateNotFoundException extends ServerException {

    public RateNotFoundException(){
        super(
                Status.NOT_FOUND.getStatusCode(),
                Status.NOT_FOUND.getStatusMessage(),
                Error.NO_RATE_FOUND.getErrorCode(),
                Error.NO_RATE_FOUND.getErrorMessage()
        );
    }
}
