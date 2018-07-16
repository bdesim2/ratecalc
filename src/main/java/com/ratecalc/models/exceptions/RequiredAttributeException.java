package com.ratecalc.models.exceptions;

import com.ratecalc.constants.Error;
import com.ratecalc.constants.Status;

/**
 * ServerException extension for when we cannot find a required attribute in a request payload
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
public class RequiredAttributeException extends ServerException {

    public RequiredAttributeException(){
        super(
                Status.BAD_REQUEST.getStatusCode(),
                Status.BAD_REQUEST.getStatusMessage(),
                Error.INVALID_REQUIRED.getErrorCode(),
                Error.INVALID_REQUIRED.getErrorMessage()
        );
    }

}
