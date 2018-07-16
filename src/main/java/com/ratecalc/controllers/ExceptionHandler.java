package com.ratecalc.controllers;

import com.ratecalc.constants.Error;
import com.ratecalc.constants.Status;
import com.ratecalc.models.response.ServiceResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
public class ExceptionHandler implements ExceptionMapper<Exception> {

    // GLOBAL CLASS VARIABLES
    private static final Logger LOGGER = LogManager.getLogger(ExceptionHandler.class);

    @Override
    public Response toResponse(Exception ex){
        final ServiceResponse error = new ServiceResponse();
        error.setTimestamp(System.currentTimeMillis());
        error.setStatusCode(Status.BAD_REQUEST.getStatusCode());
        error.setStatusMessage(Status.BAD_REQUEST.getStatusMessage());
        error.setErrorCode(Error.INTERNAL_SERVER_ERROR.getErrorCode());
        error.setErrorMessage(Error.INTERNAL_SERVER_ERROR.getErrorMessage() + " " + ex.getMessage());
        LOGGER.info("Handling Bad Request from missing or required attribute.");
        LOGGER.info(ex.getMessage());
        return Response.status(Response.Status.OK).entity(error).build();
    }

}
