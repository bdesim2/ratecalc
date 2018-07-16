package com.ratecalc.exception;

import com.ratecalc.constants.Error;
import com.ratecalc.constants.Status;
import com.ratecalc.models.exceptions.ServerException;
import com.ratecalc.models.exceptions.ServerErrorResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Exception controller that implements the build in Jersey exception mapper
 *
 * @Author Brian DeSimone
 * @Date 07/16/2018
 */
@Provider
public class InternalServerExceptionMapper implements ExceptionMapper<Exception> {

    // GLOBAL CLASS VARIABLES
    private static final Logger LOGGER = LogManager.getLogger(InternalServerExceptionMapper.class);

    @Override
    public Response toResponse(Exception ex){
        ServerException serverException;
        // Make sure we handle all instances of Application exception.. not just our base exception
        if (ex instanceof ServerException){
            serverException = (ServerException)ex;
        }
        // return the generic default internal server error if we get this far
        else {
            serverException = new ServerException(
                    Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                    Status.INTERNAL_SERVER_ERROR.getStatusMessage(),
                    Error.INTERNAL_SERVER_ERROR.getErrorCode(),
                    Error.INTERNAL_SERVER_ERROR.getErrorMessage()
            );
        }
        LOGGER.info(serverException.getErrorMessage());
        return Response
                .status(serverException.getStatusCode())
                .entity(new ServerErrorResponse(serverException))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
