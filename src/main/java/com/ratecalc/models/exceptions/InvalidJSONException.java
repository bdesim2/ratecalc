package com.ratecalc.models.exceptions;

import com.ratecalc.constants.Error;
import com.ratecalc.constants.Status;

/**
 * ServerException extension for when we have invalid JSON in a post payload
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class InvalidJSONException extends ServerException {

    public InvalidJSONException(){
        super(
                Status.BAD_REQUEST.getStatusCode(),
                Status.BAD_REQUEST.getStatusMessage(),
                Error.INVALID_JSON.getErrorCode(),
                Error.INVALID_JSON.getErrorMessage()
        );
    }

}
