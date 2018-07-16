package com.ratecalc.controllers;

import com.ratecalc.models.HealthCheck;
import com.ratecalc.models.exceptions.ServerException;
import com.ratecalc.services.IsAliveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This class provides a simple health check API that will verify the server is functioning
 *
 * @Author Brian DeSimone
 * @Date 07/13/2018
 */
@Api(value = "Healthcheck", description = "Healthcheck API", tags = "Healthcheck")
@Path(value = "/")
public class IsAliveController {

    // GLOBAL CLASS VARIABLES
    private static final Logger LOGGER = LogManager.getLogger(IsAliveController.class);
    private final transient IsAliveService isAliveService = new IsAliveService();
    private final transient AtomicLong counter = new AtomicLong();

    /**
     * API to get health check of the rate calculator application
     * @param name the name to say hello to... defaults to 'World'
     * @return the HealthCheck Object
     */
    @ApiOperation(value = "HealthCheck", nickname = "healthcheck")
    @GET
    @Path(value = "/isAlive")
    @Produces(value = {MediaType.APPLICATION_JSON})
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = "Success", response = HealthCheck.class),
            @ApiResponse(code = HttpStatus.SC_INTERNAL_SERVER_ERROR, message = "Server Error", response = ServerException.class)
    })
    public HealthCheck isAlive(
            @QueryParam(value = "name")
            @DefaultValue(value = "World")
            final String name
    ){
        LOGGER.info("Request received for API: /isAlive. Name: " + name);
        final HealthCheck healthCheck = isAliveService.getHealthCheck(name, counter);
        LOGGER.info("Response for healthcheck: " + healthCheck.toString());
        MDC.put("requestId", String.valueOf(java.util.UUID.randomUUID()));
        return healthCheck;
    }

}