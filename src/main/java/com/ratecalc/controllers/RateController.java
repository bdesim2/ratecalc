package com.ratecalc.controllers;

import com.ratecalc.core.Common;
import com.ratecalc.models.request.RateRequest;
import com.ratecalc.models.response.ServiceResponse;
import com.ratecalc.services.RateService;
import io.swagger.annotations.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * This class is the rate controller for all /rate endpoints
 *  - GET /rate/{startRate}/{endRate}
 *  - POST /rate
 *  - GET /rates
 *
 * @Author Brian DeSimone
 * @Date 07/13/2018
 */
@Api(value = "Rate", description = "Calculate Rate API", tags = "rate")
@Path("/")
public class RateController {

    // GLOBAL CLASS VARIABLES
    private static final Logger LOGGER = LogManager.getLogger(RateController.class);
    private static final Common common = new Common();
    private final transient RateService rateService = new RateService();

    /**
     * This method will calculate and return a given rate based on a start and end ISO date/time
     * @param startRate ISO date/time
     * @param endRate ISO date/time
     * @return RateResponse object including the rate
     */
    @ApiOperation(value = "Get Rate", nickname = "get rate")
    @GET
    @Path(value = "/rate/{startRate}/{endRate}")
    @Produces(value = {MediaType.TEXT_PLAIN})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = ServiceResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = ServiceResponse.class),
            @ApiResponse(code = 500, message = "Server Error", response = ServiceResponse.class)
    })
    public int getRate(
            @PathParam(value = "startRate")
            final String startRate,
            @PathParam(value = "endRate")
            final String endRate
    ){
        LOGGER.info("Calculating rate based on range: " + startRate + " - " + endRate);
        return 0;
    }

    @ApiOperation(value = "Post Rate", nickname = "post rate")
    @POST
    @Path(value = "/rate")
    @Consumes(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = ServiceResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = ServiceResponse.class),
            @ApiResponse(code = 500, message = "Server Error", response = ServiceResponse.class)
    })
    public int postRate(
            @ApiParam(name = "body", value = "The rate range to request", required = true)
            @Valid
            RateRequest rateRequest
    ){
        LOGGER.info("Reading in the request body to find a parking rate.");
        common.logObject(rateRequest);
        return 0;
    }

}
