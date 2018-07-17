package com.ratecalc.controllers;

import com.ratecalc.services.MetricsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.http.HttpStatus;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// TODO: This needs cleanup!!! need to make the responses look a lot cleaner so we can make sense of the data
// TODO: Currently it returns the generic "MetricRegistry" response

/**
 * This class is a metrics controller for all /metrics endpoints
 * - GET /metrics/responseTime
 *
 * @Author Brian DeSimone
 * @Date 07/17/2018
 */
@Api(value = "Metrics", description = "Get metrics from APIs", tags = "Metrics")
@Path("/metrics")
public class MetricsController {

    // GLOBAL CLASS VARIABLES
    private static final Logger LOGGER = LogManager.getLogger(MetricsController.class);
    private final transient MetricsService metricsService = new MetricsService();

    @ApiOperation(value = "Get Response Times", nickname = "response times")
    @GET
    @Path("responseTimes")
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiResponses(value = {
            @ApiResponse(code = HttpStatus.SC_OK, message = "Success")
    })
    public Response getResponseTimes(){
        LOGGER.info("Gathering metrics for response rate and returning.");
        return Response
                .status(Response.Status.OK)
                .entity(MetricsService.getMetricRegistry())
                .build();
    }

}