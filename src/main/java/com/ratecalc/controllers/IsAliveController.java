package com.ratecalc.controllers;

import com.ratecalc.models.HealthCheck;
import com.ratecalc.services.IsAliveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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

    @ApiOperation(value = "healthcheck", nickname = "healthcheck")
    @GET
    @Path(value = "/isAlive")
    @Produces(value = {MediaType.APPLICATION_JSON})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = HealthCheck.class),
            @ApiResponse(code = 500, message = "Server Error")
    })
    public HealthCheck isAlive(@PathParam(value = "name") final String name){
        LOGGER.info("Request received for API: /isAlive. Name: " + name);
        final HealthCheck healthCheck = isAliveService.getHealthCheck(name);
        LOGGER.info("Response for healthcheck: " + healthCheck.toString());
        MDC.put("requestId", String.valueOf(java.util.UUID.randomUUID()));
        return healthCheck;
    }

}
